import time as t


class Elevator:
    def __init__(self):
        self.current_floor = 1
        self.target_floor = 1
        self.status = "目标到达-停止"
        self.max_layer = 10
        self.min_layer = -2

        self.max_person = 13
        self.current_person = 0

        self.auto_stream = False

    def move(self):
        if self.current_floor < self.target_floor:
            self.status = "上升"
            self.current_floor += 1
        elif self.current_floor > self.target_floor:
            self.status = "下降"
            self.current_floor -= 1
        else:
            self.status = "目标到达-停止"
            self.auto_stream_fun()

    def display_person(self):
        print("电梯现有乘客: " + str(self.current_person) + " 位")

    def inc_person(self):
        if self.current_person < self.max_person:
            self.current_person += 1
            print("增加了一名乘客")
            self.display_person()
            return 0
        else:
            print("电梯满员")
            return -1

    def des_person(self):
        if self.current_person > 0:
            self.current_person -= 1
            print("减少了一名乘客")
            self.display_person()
        else:
            print("电梯已空")

    def go_to_floor(self, floor):

        if self.min_layer <= floor <= self.max_layer:
            self.target_floor = floor
            self.move()

        elif self.current_floor == floor:
            self.status = "目标到达-停止"

        else:
            self.status = "目标越界-停止"

    def open_door(self):
        self.status = "目标到达-停止"
        print("电梯门已开启")

    def close_door(self):
        self.status = "运行"
        print("电梯门已关闭")

    def display_current_floor(self):
        print(f"当前楼层：{self.current_floor}, 运行状态：{self.status}")

    def auto_move(self):
        while self.current_floor != self.target_floor:
            t.sleep(0.5)
            print("移动中，第" + str(self.current_floor) + "层...")
            self.move()

    def auto_stream_fun(self):
        if self.auto_stream:
            self.open_door()


def run_experiment(experiment_name, elevator, start_floor, target_floor=None):
    print(experiment_name)

    # 输出起始楼层和目标楼层
    print("起始楼层：", start_floor)
    if target_floor is not None:
        print("目标楼层：", target_floor)

    elevator.current_floor = start_floor

    if target_floor is not None:
        elevator.go_to_floor(target_floor)

        # 检查是否超出移动范围
        if elevator.status == "目标越界-停止":
            elevator.display_current_floor()
            print("超出移动范围，不移动")
            print("\n")
            return

        elif elevator.status == "目标到达-停止":
            elevator.display_current_floor()
            print("已到达目标楼层")
            print("\n")
            return

        elevator.auto_move()

    # 输出移动完毕和运行状态
    print("移动完毕！")
    elevator.display_current_floor()

    # 提示用户如何操作电梯
    # print("电梯操作提示：")
    # print("- 输入目标楼层来移动电梯。")
    # print("- 输入 q 退出电梯。")


def main():
    elevator = Elevator()

    # 实验一：电梯上升和下降
    run_experiment("实验一：电梯上升和下降", elevator, 1, 5)

    print("\n")

    # 实验二：电梯移动到指定楼层
    run_experiment("实验二：电梯移动到指定楼层", elevator, 3, 2)

    print("\n")

    # 实验三：电梯服务优化
    run_experiment("实验三：电梯服务优化", elevator, 1, 5)
    elevator.open_door()
    print("乘客进出电梯")
    elevator.close_door()
    elevator.current_floor = 1

    print("\n")

    # 实验四：电梯运行状态显示
    run_experiment("实验四：电梯运行状态显示", elevator, 1, 5)

    print("\n")

    while True:
        print("\n当前楼层:" + str(elevator.current_floor) + "     最高层:10,最底层:-2")

        # 提示用户输入目标楼层或退出程序
        user_input = input("输入目标楼层\n输入add_person增加电梯乘客，输入leave_person减少乘客\n输入 'q' 退出程序: ")
        if user_input == 'q':
            break

        if user_input == "person stat":
            elevator.display_person()
            continue

        if user_input == "add_person":
            elevator.inc_person()

        if user_input == "leave_person":
            elevator.des_person()

        if user_input == "display":
            elevator.display_person()

        try:
            if user_input.isdigit():
                target_floor = int(user_input)
                run_experiment("用户操作：电梯移动到指定楼层", elevator, elevator.current_floor, target_floor)
        except Exception as e:
            print("错误命令：" + str(e))
            continue


if __name__ == "__main__":
    main()
