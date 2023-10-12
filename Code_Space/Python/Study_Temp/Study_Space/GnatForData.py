import os

import requests
from bs4 import BeautifulSoup

# 定义目标网站的URL
url = 'http://www.ddcpc.cn/detail/d_guizhou/11515116213879.html'  # 替换成你要爬取的网站的URL

# 发送HTTP请求并获取页面内容
response = requests.get(url)

# 检查请求是否成功
if response.status_code == 200:
    # 使用Beautiful Soup解析页面内容
    soup = BeautifulSoup(response.text, 'html.parser')

    # 查找目标div元素
    target_div = soup.find('div', {'class': 'main'}).find('div', {'class': 'detail-box clearb'}).find('div', {
        'class': 'list-left fl'}).find('div', {'class', 'detail-content'})  # 替换成内部div的CSS类名或其他属性

    # 查找内部div元素中的图片标签
    png_tags = target_div.find_all('img')

    # 创建保存图片的文件夹
    os.makedirs('C://Users/小吴同志的R7000P/Desktop/TempPNG', exist_ok=True)

    # 遍历所有图片标签并下载图片
    for i, png_tag in enumerate(png_tags, start=1):
        png_url = png_tag.get('src')

        # 检查图片URL是否为绝对URL
        if not png_url.startswith(('http:', 'https:')):
            png_url = url + png_url

        # 发送HTTP请求以下载图片
        img_response = requests.get(png_url)

        # 提取文件名
        png_name = f'投档情况-{i}.png'

        # 保存图片到本地文件夹
        with open(f'C://Users/小吴同志的R7000P/Desktop/TempPNG/{png_name}', 'wb') as img_file:
            img_file.write(img_response.content)

    print('图片下载完成。')
else:
    print('无法访问网站。')
