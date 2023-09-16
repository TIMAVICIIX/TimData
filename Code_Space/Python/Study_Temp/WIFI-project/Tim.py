import os
import time
import winreg
from tkinter import *


class Tim(Frame):
    """
    名称：__init__(构造函数)
    功能：实例化各组件，准备窗口的挂载
    """

    def __init__(self, master):
        super().__init__(master)
        self.master = master

        self.__input_path_string = ""
        self.__output_path_string = ""

        self.__tips_content = StringVar()
        self.__tips_content.set("1.在下方输入导入和导出路径\n2.点击'刷新'按钮进行文本导入\n3.点击问题解决按钮开启程序\n4.点击'保存'按钮导出文件\n"
                                "/如果没有该导入路径，可在上方文本框输入指定格式进行程序/")

        """
        图形化界面组件实例化
        """
        self.__input_label = Label(root, text="输入文字", font=("黑体", 10))
        self.__output_label = Label(root, text="输出结果", font=("黑体", 10))
        self.__transform_label = Label(root, text="->->->转换->->->", font=("黑体", 10))
        self.__info_label = Label(root, anchor=W, justify='left',
                                  text="格式:XXXX $XXXX XXXX XX-XX-XX")
        self.__tips_label = Label(root, anchor=W, justify='left', textvariable=self.__tips_content)
        self.__load_tips = Label(root, text="导入路径:")
        self.__save_tips = Label(root, text="保存路径:")
        self.__save_command = Label(root, text="（填写保存文件夹，默认保存桌面）")

        self.__origin_text = Text(root)
        self.__result_text = Text(root)

        self.__que1_button = Button(root, text="政治问题", activebackground='gray', font=("黑体", 8),
                                    command=self.que_one)
        self.__que2_button = Button(root, text="Y2K", activebackground='gray', font=("黑体", 8), command=self.que_two)
        self.__refresh_button = Button(root, text="刷新", activebackground='gray', font=("黑体", 8),
                                       command=self.refresh)
        self.__save_button = Button(root, text="保存", activebackground='gray', font=("黑体", 8), command=self.output)
        self.__path_button = Button(root, text="保存", activebackground='gray', font=("黑体", 10),
                                    command=self.save_path)
        self.__sort_button = Button(root, text="排序", activebackground='gray', font=("黑体", 8), command=self.sort)

        self.__load_path = Entry(root)
        self.__save_path = Entry(root)

        self.start(self)

    """
    方法名称：start
    用途：图形化界面建立
    """

    @staticmethod
    def start(self):
        self.__input_label.place(x=5, y=5, width=70, height=40)

        self.__origin_text.place(x=5, y=45, width=500, height=400)

        self.__transform_label.place(x=522, y=250, width=150, height=40)

        self.__output_label.place(x=1120, y=5, width=70, height=40)

        self.__result_text.place(x=690, y=45, width=500, height=400)

        self.__que1_button.place(x=5, y=460, width=70, height=40)

        self.__que2_button.place(x=80, y=460, width=70, height=40)

        self.__refresh_button.place(x=155, y=460, width=70, height=40)

        self.__sort_button.place(x=230, y=460, width=70, height=40)

        self.__info_label.place(x=5, y=490, width=460, height=50)

        self.__tips_label.place(x=690, y=450, width=460, height=130)

        self.__save_button.place(x=1120, y=460, width=70, height=40)

        self.__load_tips.place(x=5, y=560, width=70, height=40)

        self.__load_path.place(x=80, y=560, width=425, height=30)

        self.__save_tips.place(x=5, y=600, width=70, height=40)

        self.__save_command.place(x=5, y=630, width=220, height=40)

        self.__save_path.place(x=80, y=600, width=425, height=30)

        self.__path_button.place(x=530, y=578, width=70, height=30)

    """
    名称：save_path
    功能：路径保存函数，挂载在路径保存按钮上，负责将用户输入的导入导出路径保存
    """

    def save_path(self):
        self.__input_path_string = self.__load_path.get()
        # Debug
        print(self.__input_path_string)

        self.__output_path_string = self.__save_path.get()
        # Debug
        print(self.__output_path_string)

        fut = self.__input_path_string.split(sep='.')

        if fut[-1] != 'txt':
            self.__tips_content.set("文件后缀名应为 .txt ")

    """
    名称：refresh
    功能：文本刷新函数，负责将用户提供的路径中的文本内容提取，挂载在刷新按钮上
    """

    def refresh(self):

        if os.path.isfile(self.__input_path_string):
            try:
                with open(self.__input_path_string) as fp:
                    loading_text = fp.read()

                    self.__origin_text.delete("1.0", "end")
                    self.__origin_text.insert(INSERT, loading_text)
                    self.__tips_content.set("导入成功!!!")

                    fp.close()

            except os.path:
                print("ERROR IN METHOD: def refresh(self)")
        else:
            self.__tips_content.set("文件不存在!!!")

    """
    名称：que_one
    功能：将指定字符串替换，挂载在政治问题按钮上
    """

    def que_one(self):

        if self.__origin_text.get("1.0", "end").strip():
            temp_string = self.__origin_text.get("1.0", "end")
            temp_string = temp_string.replace('Republic of China', 'Taiwan')

            self.__result_text.delete("1.0", "end")
            self.__result_text.insert(INSERT, temp_string)

            self.__tips_content.set("转换成功!!!")

        else:
            self.__tips_content.set("输入文本不能为空!!!")

    """
    名称：que_two
    功能：将指定的位置加上指定字符，挂载在Y2K按钮上
    """

    def que_two(self):

        if self.__origin_text.get("1.0", "end").strip():
            ori_string = self.__origin_text.get("1.0", "end")
            rus_string = ""

            split1_string = ori_string.split("\n")

            for t_string in split1_string:
                rus_string = rus_string + t_string[::-1].replace(" ", "91 ", 1)[::-1] + "\n"

            self.__result_text.delete("1.0", "end")
            self.__result_text.insert(INSERT, rus_string)
            self.__tips_content.set("转换成功!!!")

        else:
            self.__tips_content.set("输入文本不能为空!!!")

    """
    名称：sort
    功能：对指定字符串进行排序，挂载在排序按钮上
    """

    def sort(self):
        if self.__origin_text.get("1.0", "end").strip():
            ori_string = self.__origin_text.get("1.0", "end")
            rus_list = ori_string.split("\n")
            rus_string = ""

            for t_string in rus_list:
                rus_string = rus_string + t_string + "\n"

            self.__result_text.delete("1.0", "end")
            self.__result_text.insert(INSERT, rus_string)
            self.__tips_content.set("转换成功!!!")

    """
    名称：output
    功能：；保存输出结果，默认桌面路径，挂载在输出文本保存按钮上
    """

    def output(self):

        if os.path.exists(self.__output_path_string):
            t_string = self.__output_path_string
        else:
            self.__tips_content.set("文件夹不存在，默认保存到桌面!")
            key = winreg.OpenKey(winreg.HKEY_CURRENT_USER,
                                 r'Software\Microsoft\Windows\CurrentVersion\Explorer\Shell Folders')

            print(winreg.QueryValueEx(key, "Desktop")[0])
            t_string = winreg.QueryValueEx(key, "Desktop")[0]

        try:
            with open(t_string + "\保存文件.txt", 'w') as fp:
                fp.write(time.asctime(time.localtime()))
                fp.write("\n\n")
                fp.write(self.__result_text.get("1.0", "end"))
                fp.close()

                self.__tips_content.set("保存成功!!!")

        except os.path:
            pass


if __name__ == "__main__":
    root = Tk()
    root.geometry("1200x800")
    root.title("Tim")
    appStart = Tim(master=root)

    root.mainloop()
