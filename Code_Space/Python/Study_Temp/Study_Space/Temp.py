import tkinter as tk
from tkinter import Label, Frame

# 创建主窗口
root = tk.Tk()

# 设置窗口title
root.title("第三次作业")

# 创建标签用于显示窗口的大小和位置
info_label = Label(root, text="", font=("Arial", 12))
info_label.pack()

# 更新窗口大小和位置的函数
def update_info_label():
    window_width = root.winfo_width()
    window_height = root.winfo_height()
    window_x = root.winfo_x()
    window_y = root.winfo_y()
    info_label.config(text=f"窗口大小：{window_width}x{window_height}\n窗口位置：({window_x}, {window_y})")
    info_label.after(100, update_info_label)  # 每100毫秒更新一次

update_info_label()  # 启动更新函数

# 获取电脑屏幕的大小
screen_width = root.winfo_screenwidth()
screen_height = root.winfo_screenheight()

# 设置窗口大小
window_width = 600
window_height = 550

# 设置窗口位置居中
window_x = (screen_width - window_width) // 2
window_y = (screen_height - window_height) // 2

root.geometry(f"{window_width}x{window_height}+{window_x}+{window_y}")

# 创建包含标签的框架，并设置边框样式
frame = Frame(root, relief=tk.SUNKEN, borderwidth=10)
frame.pack(side="right")

# 设置标签内容和样式
label_text = "这是一个标签"
label_font = ("Arial", 14, "bold")
label_bg = "lightgray"
label_fg = "black"
label_width = 60
label_height = 50

# 创建标签
label = Label(frame, text=label_text, font=label_font, bg=label_bg, fg=label_fg, width=label_width, height=label_height)
label.pack(side="right")

# 在标签中显示图片
# image = tk.PhotoImage(file="your_image.gif")  # 替换为实际的图片文件路径
# label.config(image=image)
# label.image = image

# 显示窗口
root.mainloop()
