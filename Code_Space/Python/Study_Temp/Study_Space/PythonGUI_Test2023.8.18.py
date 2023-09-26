import tkinter as tk

# 创建主窗口
root = tk.Tk()

# 设置窗口title
root.title("Python人机交互界面")

# 设置窗口大小
root.geometry("400x350")

# 设置窗口的背景颜色
root.configure(bg="lightgray")

# 添加文本标签
text_label = tk.Label(root, text="欢迎使用Python人机交互界面", font=("Arial", 14), fg="blue", bg="lightgray")
text_label.pack(pady=20)

# 添加按钮
def close_window():
    root.destroy()

close_button = tk.Button(root, text="关闭窗口", command=close_window, font=("Arial", 12))
close_button.pack()

# 进入主循环
root.mainloop()
