import tkinter as tk
from tkinter import Text
from tkinter import messagebox

# 创建主窗口
root = tk.Tk()

# 设置窗口标题
root.title("第五次作业")

# 设置窗口大小
window_width = 600
window_height = 550
root.geometry(f"{window_width}x{window_height}")

# 创建Text控件
text = Text(root, width=50, height=10)
text.pack()

# 在Text控件内插入文本
text.insert(tk.INSERT, "这是一个按钮")

# 在Text控件内插入按钮
button_text = "button"
text.window_create(tk.INSERT, window=tk.Button(text, text=button_text))

# 使用 pack() 可以设置文本域的填充模式。X或Y或X、Y方向的填充
text.pack(fill=tk.BOTH, expand=True)

# 在第一行文字的第0个字符到第6个字符处插入标签 "name"
text.tag_add("name", "1.0", "1.6")

# 将插入的按钮设置其标签名为 "button"
text.tag_add("button", "2.0", "2.6")

# 使用 tag_config() 来改变标签 "name" 的前景与背景颜色，并加下划线
text.tag_config("name", foreground="blue", background="yellow", underline=True)

# 设置标签 "button" 的居中排列
text.tag_configure("button", justify="center")

# 开始程序循
root.mainloop()
