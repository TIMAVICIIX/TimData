import time

from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By

# 浏览器驱动显式等待时间
wait_second1 = 3
wait_second2 = 5

# 设置最远爬取年份
end_year = 2021

url = 'https://www.gaokao.cn/school/search'
# response = requests.get(url)

chrome_options = Options()
# 设置浏览器参数
# --headless是不 显示浏览器启动和执行过程c
# chrome_options.add_argument('--headless')
# 设置lang和User-Agent信息，防止反爬虫检测
# 设置本地已存在Chrome浏览器进行自动测试,命令提示符中输入: chrome --remote-debugging-port=9222 并保持浏览器,打开所要爬取的网站
chrome_options.add_argument('lang=zh_CN.UTF-8')
chrome_options.debugger_address = '127.0.0.1:9222'
UserAgent = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.101 ' \
            'Safari/537.36'
chrome_options.add_argument('User-Agent=' + UserAgent)

# 启动浏览器并设置chrome_options参数
driver = webdriver.Chrome(options=chrome_options)
driver.implicitly_wait(wait_second2)
driver.get(url)

# 数据处理区↓↓↓


# 数据处理区↑↑↑

# 提取方法区↓↓↓
# 全局使用abs Xpath

# 二本录取线计数器
TAG_counter = 0
# 年份省级分数线元素定位地址
TAG_year_vis = '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]' \
               '/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]'
# 年份专业分数线元素定位地址
PLAN_year_vis = '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]' \
                '/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]'


# 大学列表提取方法
def link_university():
    university_lists = driver.find_element(By.ID, 'root').find_element(By.CLASS_NAME, 'container') \
        .find_element(By.CLASS_NAME, 'container').find_element(By.CLASS_NAME, 'container') \
        .find_element(By.CLASS_NAME, 'container').find_element(By.CLASS_NAME, 'clearfix') \
        .find_element(By.CLASS_NAME, 'main').find_element(By.TAG_NAME, 'div') \
        .find_element(By.CLASS_NAME, 'content-left_box__3SjwR') \
        .find_element(By.CLASS_NAME, 'school-search_schoolListMain__B9yLk') \
        .find_element(By.CLASS_NAME, 'school-search_listBox__at-rI') \
        .find_elements(By.CLASS_NAME, 'school-search_schoolItem__3q7R2')
    return university_lists


# 屏幕点击方法
def click_method(path, wait_time):
    time.sleep(wait_time)
    driver.find_element(By.XPATH, path).click()


# 获取text方法
def get_text_method(path, wait_time):
    time.sleep(wait_time)
    return driver.find_element(By.XPATH, path).text


# 获取组件数量方法
def get_com_num(path, wait_time):
    time.sleep(wait_time)
    return len(driver.find_elements(By.XPATH, path))


# TAG的Table提取方法,不具备翻页能力以及多项选择能力
def get_table_info(path, counter):
    info_table = driver.find_element(By.XPATH, path)

    tmp_elements = info_table.find_element(By.TAG_NAME, 'tbody').find_elements(By.TAG_NAME, 'tr')

    for tr_element in tmp_elements:

        if tmp_elements.index(tr_element) == 0:
            th_elements = tr_element.find_elements(By.TAG_NAME, 'th')

            th_info = [th.text for th in th_elements]

            for tmp_info in th_info:
                print(tmp_info)

        else:
            td_elements = tr_element.find_elements(By.TAG_NAME, 'td')

            combined_str = " ".join([td.text for td in td_elements])

            if "本科二批" in combined_str:
                counter += 1

                for tmp_info in td_elements:
                    print(tmp_info.text)
            else:
                print('非本科二批信息\n')
    return counter


# PLAN的提取方法,适用于[专业分数线]与[招生计划]
def get_table_plan(path):
    print('查找任务开始')
    change_page_num = get_com_num('/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]'
                                  '/div[3]/div[1]/div[1]/div[1]/div[3]/div[2]/div[3]/div[1]/div[1]/ul[1]/li', 0) - 2

    print('列表总页数:' + str(change_page_num))

    change_btn_position = get_com_num('/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/'
                                      'div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]'
                                      '/div[2]/div[3]/div[1]/div[1]/ul[1]/li', 0)

    print('列表下一页按钮位置:' + str(change_btn_position))

    for i in range(0, change_page_num):

        info_table = driver.find_element(By.XPATH, path)

        tmp_elements = info_table.find_element(By.TAG_NAME, 'tbody').find_elements(By.TAG_NAME, 'tr')

        for tr_element in tmp_elements:

            if tmp_elements.index(tr_element) == 0:
                th_elements = tr_element.find_elements(By.TAG_NAME, 'th')

                th_info = [th.text for th in th_elements]

                for tmp_info in th_info:
                    print(tmp_info)

            else:
                td_elements = tr_element.find_elements(By.TAG_NAME, 'td')
                td_info = [td.text for td in td_elements]

                for tmp_info in td_info:
                    print(tmp_info)

        # 点击Table翻页
        if change_page_num != 1:
            click_method('/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]'
                         '/div[1]/div[1]/div[1]/div[3]/div[2]/div[3]/div[1]/div[1]/ul[1]/li[' +
                         str(change_btn_position) + ']', 0)


# 更换年份
def change_inner_year(path_open, path_chose):
    time.sleep(7)
    driver.find_element(By.XPATH, path_open).click()
    time.sleep(2)
    driver.find_element(By.XPATH, path_chose).click()


# 退出页面并关闭
def quit_web_page():
    driver.close()
    driver.switch_to.window(driver.window_handles[0])


# 下一页大学列表
def change_main_page():
    driver.find_element(By.XPATH, '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]'
                                  '/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/ul[1]/li[9]').click()


# 提取方法区↑↑↑

# 代码执行区
# Relate/Tips
# 外循环(对列表展示界面进行遍历)->内循环(对列表展示界面中的各列表项进行遍历)
# 外循环,首先获取列表界面数量
university_list_range = 145

for j in range(university_list_range):

    print('列表第' + str(j) + '页\n')
    # 定位单页面界面各大学列表点击按钮
    university_list = link_university()

    # Debug
    print('大学界面列表提取完毕\n')

    for i, university in enumerate(university_list, start=1):
        # time.sleep(10)

        un_btn = university.find_element(By.CLASS_NAME, 'school-search_schoolInfo__2sLfR')
        print('\n序号' + str(i) + ' ' + un_btn.text)
        # driver.execute_script("arguments[0].click();", un_btn)
        un_btn.click()

        # 当前URL被重新定向到新页面，需要转到新的URL界面
        driver.switch_to.window(driver.window_handles[1])
        print('\n进入大学主界面,当前URL:' + driver.current_url + '\n')

        # Debug
        # 对第二部分[专业分数线]的单元测试,测试目标:爬取精度
        # 测试URL: https://www.gaokao.cn/school/521
        # 测试结果:测试修改成功,解决Table为一页时任然翻页问题
        # 测试代码如下:
        # driver.execute_script('window.location.href="https://www.gaokao.cn/school/521";')

        # 点击[分数/计划]按钮
        click_method('/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]'
                     '/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[5]/div[2]', 3)

        # 第一部分:TAG查找开始
        # 获得现在年份,在现在年份与最终年份之间循环查找,并记录有无二本录取情况
        # 设置二本录取情况
        start_year = int(get_text_method('/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]'
                                         '/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]'
                                         '/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/span[1]/div[1]'
                                         '/div[1]/div[1]/div[1]', 1))

        for i in range(2, (start_year - end_year) + 3):

            print('TAG中当前查找年份:' + get_text_method(
                '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]'
                '/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]'
                '/form[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]', 0))

            # 选择文科，如果现有文科则不选择，如果没有呈现则击文理科按钮并选择文史，如果没有文科则直接跳过该年份
            if get_text_method('/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]'
                               '/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]',
                               0) != '文科':

                click_method('/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]'
                             '/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]', 5)

                if get_com_num('/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]'
                               '/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]'
                               '/div[3]/div[2]/div[1]/div[1]/div[1]/ul[1]/li', 0) == 2:
                    click_method('/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]'
                                 '/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]'
                                 '/div[1]/div[1]/div[1]/ul[1]/li[2]', 1)

                else:
                    print('当前年份无文科信息,切换年份或退出本页面')
                    change_inner_year(TAG_year_vis,
                                      '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]'
                                      '/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]'
                                      '/div[1]/div[1]/span[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[' + str(i) + ']')
                    continue

            # 进行二本信息查找
            TAG_counter += get_table_info('/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]'
                                          '/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]',
                                          TAG_counter)

            print('当前年份文科信息收集完毕,切换年份,Table或退出本页面')
            change_inner_year(TAG_year_vis,
                              '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]'
                              '/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]'
                              '/div[1]/div[1]/span[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[' + str(i) + ']')

        if TAG_counter == 0:
            print('该校近几年无二本招生情况，退出该页')
            quit_web_page()
            continue
        else:
            TAG_counter = 0

        # 进行专业分数线信息查找
        # 第二部分:对专业分数线进行查找,后期可能进行方法抽象优化
        print('\n开始查找专业分数线')
        for i in range(2, (start_year - end_year) + 2):

            print('\n专业分数线中当前查找年份:' + get_text_method(
                '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]'
                '/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]'
                '/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]', 0))

            # 选择文科，如果现有文科则不选择，如果没有呈现则击文理科按钮并选择文史，如果没有文科则直接跳过该年份
            if get_text_method(
                    '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]'
                    '/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]',
                    0) != '文科':

                click_method('/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]'
                             '/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]', 1)

                if get_com_num('/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]'
                               '/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]'
                               '/div[3]/div[2]/div[1]/div[1]/div[1]/ul[1]/li', 0) == 2:
                    click_method('/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]'
                                 '/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[2]'
                                 '/div[1]/div[1]/div[1]/ul[1]/li[2]', 1)

                else:
                    print('当前年份无文科信息,切换年份或退出本页面')
                    change_inner_year(PLAN_year_vis,
                                      '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]'
                                      '/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]'
                                      '/div[1]/span[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[' + str(i) + ']')
                    continue

                if get_text_method(
                        '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]'
                        '/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[4]/form[1]/div[1]'
                        '/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]',
                        0) != '本科二批':

                    click_method('/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]'
                                 '/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]'
                                 '/div[1]/div[4]/form[1]/div[1]/div[1]/div[1]', 1)

                    if get_com_num('/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]'
                                   '/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]'
                                   '/div[4]/form[1]/div[1]/div[1]/div[1]/span[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li',
                                   0) == 2:
                        click_method('/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]'
                                     '/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[4]/form[1]/div[1]/div[1]'
                                     '/div[1]/span[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]', 1)

                    else:
                        print('当前年份无文科信息,切换年份或退出本页面')
                        change_inner_year(PLAN_year_vis,
                                          '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]'
                                          '/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]'
                                          '/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]'
                                          '/div[1]/span[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[' + str(i) + ']')
                        continue

            # 进行二本信息查找
            # driver.execute_script(f"window.scrollBy(0,70);")
            get_table_plan('/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]'
                           '/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/table[1]')

            driver.execute_script(f"window.scrollBy(0,-250);")
            print('当前年份文科信息收集完毕,切换年份或退出本页面')
            change_inner_year(PLAN_year_vis,
                              '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]'
                              '/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]'
                              '/div[1]/span[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[' + str(i) + ']')

        quit_web_page()

    # 加入翻页功能进入外循环
    change_main_page()

    driver.quit()
