import tkinter as tk
import tkinter.filedialog


class SimpleEditor:
    def __init__(self, root_in):
        self.root = root_in
        self.create_widgets()

    def create_widgets(self):
        # 创建菜单栏
        self.menu_bar = tk.Menu(self.root)
        self.root.config(menu=self.menu_bar)

        # 创建文件菜单
        self.file_menu = tk.Menu(self.menu_bar, tearoff=0)
        self.menu_bar.add_cascade(label="File", menu=self.file_menu)
        self.file_menu.add_command(label="Open", command=self.open_file)
        self.file_menu.add_command(label="Save", command=self.save_file)
        self.file_menu.add_separator()
        self.file_menu.add_command(label="Exit", command=self.root.quit)

        # 创建编辑菜单
        self.edit_menu = tk.Menu(self.menu_bar, tearoff=0)
        self.menu_bar.add_cascade(label="Edit", menu=self.edit_menu)
        self.edit_menu.add_command(label="Cut", command=self.cut_text)
        self.edit_menu.add_command(label="Copy", command=self.copy_text)
        self.edit_menu.add_command(label="Paste", command=self.paste_text)

        # 文本框
        self.text_entry = tk.Text(self.root)
        self.text_entry.pack()

        # 保存按钮
        self.save_button = tk.Button(self.root, text="Save", command=self.save_file)
        self.save_button.pack()

        # 其他功能按钮
        self.other_button = tk.Button(self.root, text="Other", command=self.other_function)
        self.other_button.pack()

    def open_file(self):
        # 实现打开文件的功能
        file_path = tkinter.filedialog.askopenfilename(filetypes=[("Text files", "*.txt")])

        if file_path:
            with open(file_path, 'r', encoding='utf-8') as file:
                content = file.read()
                self.text_entry.delete(1.0, tk.END)
                self.text_entry.insert(tk.END, content)

    def save_file(self):
        # 实现保存文件的功能
        file_path = tk.filedialog.asksaveasfilename(defaultextension=".txt",
                                                    filetypes=[("Text files", "*.txt")])
        if file_path:
            with open(file_path, 'w') as file:
                content = self.text_entry.get(1.0, tk.END)
                file.write(content)

    def cut_text(self):
        # 实现剪切文本的功能
        self.text_entry.event_generate("<<Cut>>")

    def copy_text(self):
        # 实现复制文本的功能
        self.text_entry.event_generate("<<Copy>>")

    def paste_text(self):
        # 实现粘贴文本的功能
        self.text_entry.event_generate("<<Paste>>")

    def other_function(self):
        # 实现其他功能按钮的功能
        text_content = self.text_entry.get(1.0, tk.END)

        # 统计字数（假设字数以空格分隔）
        word_count = len(text_content.split())

        # 显示字数统计结果
        word_count_label = tk.Label(self.root, text=f"字数统计: {word_count} 字")
        word_count_label.pack()


root = tk.Tk()
app = SimpleEditor(root)
root.mainloop()
