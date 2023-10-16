import tkinter as tk
from tkinter import Label, Entry, Button
from tkinter import messagebox

# 创建主窗口
root = tk.Tk()

# 设置窗口标题
root.title("第四次作业")

# 设置窗口大小和位置
window_width = 300
window_height = 200
window_x = 100
window_y = 100
root.geometry(f"{window_width}x{window_height}+{window_x}+{window_y}")

# 创建标签“账号”
account_label = Label(root, text="账号:")
account_label.grid(row=0, column=0, padx=10, pady=10, sticky=tk.W)

# 创建标签“密码”
password_label = Label(root, text="密码:")
password_label.grid(row=1, column=0, padx=10, pady=10, sticky=tk.W)

# 创建输入框控件
account_entry = Entry(root)
account_entry.grid(row=0, column=1, padx=10, pady=10, sticky=tk.W)

password_entry = Entry(root, show="*")  # 以 * 形式显示密码
password_entry.grid(row=1, column=1, padx=10, pady=10, sticky=tk.W)


# 定义登录按钮点击时的函数
def click_button():
    messagebox.showinfo("温馨提示", "欢迎登录")


# 创建登录按钮
login_button = Button(root, text="登录", command=click_button)
login_button.grid(row=2, column=0, padx=10, pady=10, sticky=tk.W)

# 创建退出按钮
exit_button = Button(root, text="退出", command=root.quit)
exit_button.grid(row=2, column=1, padx=10, pady=10, sticky=tk.E)

# 进入主循环
root.mainloop()
