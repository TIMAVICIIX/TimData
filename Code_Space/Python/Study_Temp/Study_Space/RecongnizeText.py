import pytesseract
from PIL import Image

# 打开图像文件
image = Image.open('C://Users/小吴同志的R7000P/Desktop/TempPNG/投档情况-1.png')  # 替换成你要识别的图像文件的路径

# 使用Tesseract进行文字识别
text = pytesseract.image_to_string(image, lang='eng+chi_sim+num')

# 打印识别的文本
print(text)
