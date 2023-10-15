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

# 被优化方案
# outter_xpath_expression = "//div[@id='root']/div[@class='container']" \
#                           "/div[@class='container']" \
#                           "/div[@class='container']" \
#                           "/div[@class='container']" \
#                           "/div[@class='home_index_wrap']" \
#                           "/div[@class='clearfix']" \
#                           "/div[@class='main-nav_mainNavWrap__o2m5H']" \
#                           "/div[@class='main-nav_mainNav__1qgwf]" \
#                           "/div[@class='main-nav_navBox__MY9It']" \
#                           "/div[@class='main-nav_navItem__3w2xP ']"
# driver.find_element(By.ID, 'root').find_element(By.CLASS_NAME, 'container') \
#     .find_element(By.CLASS_NAME, 'container').find_element(By.CLASS_NAME, 'container') \
#     .find_element(By.CLASS_NAME, 'container').find_element(By.CLASS_NAME, 'home_index_wrap') \
#     .find_element(By.CLASS_NAME, 'clearfix').find_element(By.CLASS_NAME, 'main-nav_mainNavWrap__o2m5H') \
#     .find_element(By.CLASS_NAME, 'main-nav_mainNav__1qgwf').find_element(By.CLASS_NAME, 'main-nav_navBox__MY9It') \
#     .find_elements(By.CLASS_NAME, 'main-nav_navItem__3w2xP')[2].click()
# driver.find_element(By.XPATH, outter_xpath_expression).click()
# inner_xpath_expression = "//div[@id='root']/div[@class='container']" \
#                          "/div[@class='container']" \
#                          "/div[@class='container']" \
#                          "/div[@class='container']" \
#                          "/div[@class='clearfix']" \
#                          "/div[@c0lass='main']" \
#                          "/div[@class='layoutWrap clearfix']" \
#                          "/div[@class='content-left_box__3SjwR']" \
#                          "/div[@class='school-search_schoolListMain__B9yLk']" \
#                          "/div[@class='school-search_listBox__at-rI']" \
#                          "/div[@class='school-search_schoolItem__3q7R2']" \
#                          "/div[@class='school-search_schoolInfo__2sLfR']"


# Relate/Tips
# 外循环(对列表展示界面进行遍历)->内循环(对列表展示界面中的各列表项进行遍历)
# 外循环,首先获取列表界面数量

university_list_range = 145

for j in range(university_list_range):

    print('列表第' + str(j) + '页\n')
    # 定位单页面界面各大学列表点击按钮
    university_list = driver.find_element(By.ID, 'root').find_element(By.CLASS_NAME, 'container') \
        .find_element(By.CLASS_NAME, 'container').find_element(By.CLASS_NAME, 'container') \
        .find_element(By.CLASS_NAME, 'container').find_element(By.CLASS_NAME, 'clearfix') \
        .find_element(By.CLASS_NAME, 'main').find_element(By.TAG_NAME, 'div') \
        .find_element(By.CLASS_NAME, 'content-left_box__3SjwR') \
        .find_element(By.CLASS_NAME, 'school-search_schoolListMain__B9yLk') \
        .find_element(By.CLASS_NAME, 'school-search_listBox__at-rI') \
        .find_elements(By.CLASS_NAME, 'school-search_schoolItem__3q7R2')

    # Debug
    print('大学界面列表提取完毕\n')

    for i, university in enumerate(university_list, start=1):

        # time.sleep(10)

        un_btn = university.find_element(By.CLASS_NAME, 'school-search_schoolInfo__2sLfR')
        print('序号' + str(i) + ' ' + un_btn.text)
        # driver.execute_script("arguments[0].click();", un_btn)
        un_btn.click()

        # 当前URL被重新定向到新页面，需要转到新的URL界面
        driver.switch_to.window(driver.window_handles[1])
        print('\n进入大学主界面,当前URL:' + driver.current_url + '\n')

        # 添加时延
        time.sleep(wait_second1)

        # 点击[分数/计划]按钮
        driver.find_element(By.ID, 'root') \
            .find_element(By.CLASS_NAME, 'container') \
            .find_element(By.CLASS_NAME, 'container') \
            .find_element(By.CLASS_NAME, 'container') \
            .find_element(By.CLASS_NAME, 'container') \
            .find_elements(By.TAG_NAME, 'div')[0] \
            .find_element(By.TAG_NAME, 'div') \
            .find_element(By.CLASS_NAME, 'main') \
            .find_element(By.TAG_NAME, 'div') \
            .find_element(By.CLASS_NAME, 'relative-for-liuyan') \
            .find_element(By.CLASS_NAME, 'relative_box') \
            .find_element(By.CLASS_NAME, 'schooltab-menu') \
            .find_elements(By.TAG_NAME, 'div')[1].click()

        # 点击文理科按钮并且选择文史
        # 添加时延
        time.sleep(wait_second1)
        option_btn = driver.find_element(By.ID, 'root') \
            .find_element(By.ID, 'proline') \
            .find_elements(By.TAG_NAME, 'div')[0] \
            .find_element(By.CLASS_NAME, 'scoreLine-dropDown') \
            .find_elements(By.CLASS_NAME, 'dropdown-box')[2]

        option_btn.click()

        # Debug 优化模糊定位,使用断点测试
        # 采用XPath搜寻
        choose_list = driver.find_elements(By.XPATH, '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]'
                                                     '/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]'
                                                     '/div[3]/div[2]/div[1]/div[1]/div[1]/ul[1]/li')
        print('断点测试成功')

        # 文史类选择框 Debug
        if len(choose_list) == 2:
            driver.find_element(By.XPATH, '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]'
                                          '/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]'
                                          '/div[3]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]').click()

            # 选择文史,使用模糊定位
            # 被优化方案1
            # action = ActionChains(driver)
            # action.move_to_element(option_btn)
            # action.move_by_offset(0, 76)
            # action.click()
            # action.perform()
            # option_btn.find_elements(By.TAG_NAME, 'div')[1] \
            #     .find_element(By.TAG_NAME, 'div') \
            #     .find_element(By.TAG_NAME, 'div') \
            #     .find_element(By.TAG_NAME, 'ul') \
            #     .find_elements(By.TAG_NAME, 'li')[1].click()
            # 被优化方案2
            # driver.find_element(By.ID, '19a23279-d52e-433f-ea4b-a8bd33398041') \
            #     .find_element(By.TAG_NAME, 'ul') \
            #     .find_elements(By.TAG_NAME, 'li')[1].click()
            # 被优化方案3
            # driver.find_element(By.ID, 'root') \
            #     .find_element(By.ID, 'proline') \
            #     .find_elements(By.TAG_NAME, 'div')[0] \
            #     .find_element(By.CLASS_NAME, 'scoreLine-dropDown') \
            #     .find_elements(By.CLASS_NAME, 'dropdown-box')[2] \
            #     .find_elements(By.TAG_NAME, 'div')[1] \
            #     .find_element(By.TAG_NAME, 'div') \
            #     .find_element(By.CLASS_NAME,
            #                   'ant-select-dropdown ant-select-dropdown--single '
            #                   'ant-select-dropdown-placement-bottomLeft  '
            #                   'ant-select-dropdown-hidden') \
            #     .find_element(By.ID, '19a23279-d52e-433f-ea4b-a8bd33398041') \
            #     .find_element(By.TAG_NAME, 'ul') \
            #     .find_elements(By.TAG_NAME, 'li')[1].click()
            # 被优化方案4
            # Debug
            # first_debug = driver.find_element(By.ID, 'root') \
            #     .find_element(By.CLASS_NAME, 'container') \
            #     .find_element(By.CLASS_NAME, 'container') \
            #     .find_element(By.CLASS_NAME, 'container') \
            #     .find_element(By.CLASS_NAME, 'container') \
            #     .find_elements(By.TAG_NAME, 'div')[0] \
            #     .find_element(By.CLASS_NAME, 'clearfix') \
            #     .find_element(By.CLASS_NAME, 'main') \
            #     .find_element(By.TAG_NAME, 'div') \
            #     .find_elements(By.TAG_NAME, 'div')
            #
            # for element in first_debug:
            #     print(element.get_attribute('class'))

            # 获取分数
            # 优化方向:在HTML中寻找元素时，使用find_element(s)方法优先入参ID号,ID号具有全局唯一性，可进行整个页面递归遍历寻找
            # 入参优先级建议:ID>CLASS_NAME>TEXT>TAG_NAME
            # driver.find_element(By.ID, 'root') \
            #     .find_element(By.CLASS_NAME, 'container') \
            #     .find_element(By.CLASS_NAME, 'container') \
            #     .find_element(By.CLASS_NAME, 'container') \
            #     .find_element(By.CLASS_NAME, 'container') \
            #     .find_elements(By.TAG_NAME, 'div')[0] \
            #     .find_element(By.CLASS_NAME, 'clearfix') \
            #     .find_element(By.CLASS_NAME, 'main') \
            #     .find_element(By.TAG_NAME, 'div') \
            #     .find_elements(By.TAG_NAME, 'div')[2] \
            #     .find_elements(By.TAG_NAME, 'div')[0] \
            #     .find_elements(By.TAG_NAME, 'div')[0] \
            #     .find_element(By.TAG_NAME, 'div') \
            #     .find_element(By.CLASS_NAME, 'schoolLine clearfix') \
            #     .find_element(By.CLASS_NAME, 'province_score_line_table') \
            #     .find_element(By.CLASS_NAME, 'line_table_box') \
            #     .find_element(By.TAG_NAME, 'table')

            # 获取分数,记录是否有本科二批录取情况
            # 添加时延
            time.sleep(wait_second1)

            second_stream = 0
            line_table = driver.find_element(By.ID, 'proline') \
                .find_element(By.CLASS_NAME, 'province_score_line_table') \
                .find_element(By.CLASS_NAME, 'line_table_box') \
                .find_element(By.TAG_NAME, 'table')

            tr_elements = line_table.find_element(By.TAG_NAME, 'tbody').find_elements(By.TAG_NAME, 'tr')

            for tr_element in tr_elements:

                if tr_elements.index(tr_element) == 0:
                    th_elements = tr_element.find_elements(By.TAG_NAME, 'th')

                    th_info = [th.text for th in th_elements]

                    for tmp_info in th_info:
                        print(tmp_info)

                else:
                    td_elements = tr_element.find_elements(By.TAG_NAME, 'td')

                    for tmp_info in td_elements:

                        if "本科二批" in tmp_info.text:
                            second_stream += 1
                            print(tmp_info.text)

                        else:
                            continue

            # 获取专业分数线(本科二批):2023,2022,2021
            # 判断是否有本科二批专业分数线，没有直接跳过
            # 有二本招生记录，开始从专业分数线爬取记录
            if second_stream == 0:
                print('本科二批无录取记录,跳过\n')
                driver.close()
                driver.switch_to.window(driver.window_handles[0])
                continue

            # 开始爬取专业分数线与招生计划
            # 1.点击文理科，选择文科
            # 2.点击文科选项
            driver.find_element(By.XPATH, '/html[1]/body[1]/div[1]/div[1]/div[1]'
                                          '/div[1]/div[1]/div[1]/div[1]/div[2]'
                                          '/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]'
                                          '/div[1]/div[1]/div[3]/div[1]').click()
            driver.find_element(By.XPATH, '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]'
                                          '/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]'
                                          '/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]').click()

            driver.find_element(By.XPATH, '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]'
                                          '/div[1]/div[3]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[3]').click()
            driver.find_element(By.XPATH, '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]'
                                          '/div[1]/div[3]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[3]'
                                          '/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]').click()

            # 3.点击本科一二批，选择本科二批
            # 3.1.如果没有一批，直接开始爬取
            # 3.2.如果有本科一批，修改为本科二批
            if driver.find_element(By.XPATH, '/html[1]/body[1]/div[1]/div[1]/div[1]'
                                             '/div[1]/div[1]/div[1]/div[1]/div[2]'
                                             '/div[1]/div[3]/div[1]/div[1]/div[1]'
                                             '/div[3]/div[1]/div[1]/div[4]/form[1]/'
                                             'div[1]/div[1]/div[1]/span[1]/div[1]'
                                             '/div[1]/div[1]/div[1]').text == '本科一批':
                # 3.2.1修改为本科二批
                driver.find_element(By.XPATH, '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]'
                                              '/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]'
                                              '/div[4]/form[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]').click()
                driver.find_element(By.XPATH, '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]'
                                              '/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]'
                                              '/div[4]/form[1]/div[1]/div[1]/div[1]/span[1]/div[2]/div[1]'
                                              '/div[1]/div[1]/ul[1]/li[2]').click()

            if driver.find_element(By.XPATH, '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]'
                                             '/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]'
                                             '/div[4]/form[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]'
                                             '/div[1]/div[1]').text == '本科一批':
                # 3.2.1修改为本科二批
                driver.find_element(By.XPATH, '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]'
                                              '/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]'
                                              '/div[4]').click()
                driver.find_element(By.XPATH, '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]'
                                              '/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]'
                                              '/div[4]/form[1]/div[1]/div[1]/div[1]/span[1]/div[2]/div[1]'
                                              '/div[1]/div[1]/ul[1]/li[2]').click()

            # 获取最近专业分数线年份
            score_start_year = int(
                driver.find_element(By.XPATH, '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]'
                                              '/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]'
                                              '/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]'
                                              '/span[1]/div[1]/div[1]/div[1]/div[1]').text)

            # 获取最大展示页数
            score_display_page = int(len(driver.find_elements(By.XPATH,
                                                              '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/'
                                                              'div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/'
                                                              'div[1]/div[1]/div[3]/div[2]/div[3]/div[1]/div[1]/ul[1]')))

            # 专业分数线
            # 在最近年份与最终年份之间爬取
            for i in range((score_start_year - end_year) + 1):

                # 输出最近计划年份
                print('当前选择年份' + driver.find_element(By.XPATH,
                                                           '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/'
                                                           'div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]'
                                                           '/div[1]/div[3]/div[1]/div[1]/div[2]'
                                                           '/form[1]/div[1]/div[1]/div[1]'
                                                           '/span[1]/div[1]/div[1]/div[1]/div[1]').text+'\n')

                table_of_score = driver.find_element(By.XPATH, '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]'
                                                               '/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]'
                                                               '/div[1]/div[3]/div[2]/div[1]/table[1]')

                tr_elements = table_of_score.find_element(By.TAG_NAME, 'tbody').find_elements(By.TAG_NAME, 'tr')

                for tr_element in tr_elements:

                    if tr_elements.index(tr_element) == 0:
                        th_elements = tr_element.find_elements(By.TAG_NAME, 'th')

                        th_info = [th.text for th in th_elements]

                        for tmp_info in th_info:
                            print(tmp_info)

                    else:
                        td_elements = tr_element.find_elements(By.TAG_NAME, 'td')

                        td_info = [td.text for td in td_elements]

                        for tmp_info in td_info:
                            print(tmp_info)

                # 点击下一页继续爬取

                driver.find_element(By.XPATH, '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]'
                                              '/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/div[2]'
                                              '/div[3]/div[1]/div[1]/ul[1]/li[' + str(score_display_page) + ']').click()

            # 获取各专业招生计划年份
            plan_start_year = int(driver.find_element(By.XPATH, '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]'
                                                                '/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]'
                                                                '/div[1]/div[4]/div[1]/div[1]/div[2]/form[1]/div[1]'
                                                                '/div[1]/div[1]/span[1]/div[1]/div[1]'
                                                                '/div[1]/div[1]').text)

            # 获取最大展示页
            plan_display_page = int(len(driver.find_elements(By.XPATH, '/html[1]/body[1]/div[1]/div[1]/div[1]'
                                                                       '/div[1]/div[1]/div[1]/div[1]/div[2]'
                                                                       '/div[1]/div[3]/div[1]/div[1]/div[1]'
                                                                       '/div[4]/div[2]/div[3]/div[1]/div[1]/ul[1]')))

            # 招生计划
            # 在最近年份与最终年份之间爬取
            for i in range(1, (plan_start_year - end_year) + 1):

                # 输出当前爬取年份
                print('当前选择年份'+driver.find_element(By.XPATH, '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]'
                                                                   '/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]'
                                                                   '/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]'
                                                                   '/div[2]/form[1]/div[1]/div[1]/div[1]'
                                                                   '/span[1]/div[1]/div[1]/div[1]/div[1]').text)

                table_of_plan = driver.find_element(By.XPATH, '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]'
                                                              '/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]'
                                                              '/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/table[1]')

                tr_elements = table_of_plan.find_element(By.TAG_NAME, 'tbody').find_elements(By.TAG_NAME, 'tr')

                for tr_element in tr_elements:

                    if tr_elements.index(tr_element) == 0:
                        th_elements = tr_element.find_elements(By.TAG_NAME, 'th')

                        th_info = [th.text for th in th_elements]

                        for tmp_info in th_info:
                            print(tmp_info)

                    else:
                        td_elements = tr_element.find_elements(By.TAG_NAME, 'td')

                        td_info = [td.text for td in td_elements]

                        for tmp_info in td_info:
                            print(tmp_info)

                # 点击下一页继续爬取

                driver.find_element(By.XPATH, '/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]'
                                              '/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/div[2]'
                                              '/div[3]/div[1]/div[1]/ul[1]/li[5]').click()

            # 关闭大学主界面,退回到列表界面
            driver.close()
            driver.switch_to.window(driver.window_handles[0])

        else:
            print('无文科录取状况,跳回列表并不做记录\n')
            driver.close()
            driver.switch_to.window(driver.window_handles[0])

    # 时延，退回列表界面后点击下一页进行信息收集
    time.sleep(wait_second1)

    driver.find_element(By.ID, 'root') \
        .find_element(By.CLASS_NAME, 'container') \
        .find_element(By.CLASS_NAME, 'container') \
        .find_element(By.CLASS_NAME, 'container') \
        .find_element(By.CLASS_NAME, 'container') \
        .find_element(By.CLASS_NAME, 'clearfix') \
        .find_element(By.CLASS_NAME, 'main') \
        .find_element(By.TAG_NAME, 'div') \
        .find_element(By.CLASS_NAME, 'content-left_box__3SjwR') \
        .find_element(By.CLASS_NAME, 'school-search_schoolListMain__B9yLk') \
        .find_element(By.CLASS_NAME, 'school-search_listBox__at-rI') \
        .find_element(By.CLASS_NAME, 'laypage') \
        .find_element(By.CLASS_NAME, 'pagination_box') \
        .find_element(By.TAG_NAME, 'ul') \
        .find_elements(By.TAG_NAME, 'li')[8].click()

driver.quit()
