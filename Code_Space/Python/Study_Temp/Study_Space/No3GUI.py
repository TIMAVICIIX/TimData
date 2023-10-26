import tkinter as tk
from tkinter import Label, Frame

from PIL import ImageTk

# 创建主窗口
root = tk.Tk()

# 设置窗口title
root.title("第三次作业")

# 创建标签用于显示窗口的大小和位置
info_label = Label(root, text="", font=("Arial", 12))
info_label.pack()


# 更新窗口大小和位置的函数
def update_info_label():
    window_wi = root.winfo_width()
    window_he = root.winfo_height()
    window_xx = root.winfo_x()
    window_yy = root.winfo_y()
    info_label.config(text=f"窗口大小：{window_wi}x{window_he}\n窗口位置：({window_xx}, {window_yy})")
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

# 设置标签内容和样式
label_text = "Yuuka"
label_font = ("Arial", 14, "bold")
label_bg = "lightgray"
label_fg = "black"
label_width = 400
label_height = 400

# 创建Frame用于边框样式
frame = Frame(root, relief=tk.SUNKEN, borderwidth=10)
frame.pack(pady=20, padx=25,side="right")

# 创建标签
label = Label(frame, text=label_text, font=label_font, bg=label_bg, fg=label_fg, width=label_width, height=label_height)
label.pack(side="right")

# 在标签中显示图片
image_path = r"C:\Users\小吴同志的R7000P\Pictures\Saved Pictures\output_icon.ico"
image = ImageTk.PhotoImage(file=image_path)  # 替换为实际的图片文件路径
label.config(image=image, compound="top")
label.image = image


# 显示窗口
root.mainloop()
