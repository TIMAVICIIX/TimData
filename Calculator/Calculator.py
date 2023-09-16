import datetime as dt
import math

def calculator():
    print("欢迎使用命令行计算器！支持以下操作：")
    print("1. 输入数学表达式并按 Enter 计算。")
    print("     支持的操作符：+（加法），-（减法），*（乘法），/（除法），^（乘方），sqrt（开方）.")
    print("     例如：2 + 3，4 * 5，sqrt(9)。")
    print("2. 输入 'list' 查看历史记录。")
    print("     显示之前的计算历史。")
    print("3. 输入 'stats' 进入数据统计模式。")
    print("     输入一个数组以进行统计操作。")
    print("     支持的统计操作：max（最大值），min（最小值），avg（平均值）。")
    print("     例如：[1, 2, 3]，max，min，avg。")
    print("     输入 'exit stats' 退出数据统计模式。")
    print("4. 输入 'quit' 退出计算器。")

    history = []  # 用于保存计算历史的列表
    numbers = []  # 用于保存数字以进行统计计算

    while True:
        expression = input("请输入数学表达式：")

        if expression.lower() == 'quit':
            break
        elif expression.lower() == 'list':
            # 显示历史记录
            if not history:
                print("历史记录为空")
            else:
                print("历史记录：")
                for i, item in enumerate(history, 1):
                    print(f"{i}. {item}")
            continue
        elif expression.lower() == 'stats':
            # 进入统计模式
            numbers.clear()  # 清空之前的统计数据
            print("进入数据统计模式。")
            print("请输入一个数组以进行统计操作。")
            print("支持的统计操作：max（最大值），min（最小值），avg（平均值）。")
            print("例如：[1, 2, 3]，max，min，avg。")
            print("输入 'exit stats' 退出数据统计模式。")

            while True:
                stat_expression = input("请输入要统计的数组,输入exit put进入数据操作：")
                if stat_expression.lower() == 'exit put':
                    break
                try:
                    # 解析用户输入的列表
                    if stat_expression.startswith("[") and stat_expression.endswith("]"):
                        num_list = eval(stat_expression)
                        if isinstance(num_list, list):
                            numbers.extend(num_list)
                            print("数组已添加到统计列表中")
                        else:
                            print("无效的数组输入")
                    else:
                        print("无效的数组输入")
                except Exception as e:
                    print("发生错误:", str(e))

            print("输入的数组：" + ','.join(map(str, numbers)))

            # 执行数据统计操作
            while True:
                stat_operation = input("请输入数据统计操作或输入 'exit stats' 退出统计模式：")
                if stat_operation.lower() == 'exit stats':
                    numbers.clear()
                    break
                elif stat_operation.lower() == 'max':
                    if numbers:
                        max_value = max(numbers)
                        print(f"最大值：{max_value}")
                        # 记录数据统计操作到历史记录中
                        history.append(f"数据统计操作：最大值 = {max_value}" +
                                       " \n操作时间：" + dt.datetime.now().strftime('%Y-%m-%d  %H:%M:%S') +
                                       "\n操作数组：" + ','.join(map(str, numbers)))
                    else:
                        print("无数据进行统计")
                elif stat_operation.lower() == 'min':
                    if numbers:
                        min_value = min(numbers)
                        print(f"最小值：{min_value}")
                        # 记录数据统计操作到历史记录中
                        history.append(f"数据统计操作：最小值 = {min_value}" +
                                       " \n操作时间：" + dt.datetime.now().strftime('%Y-%m-%d  %H:%M:%S') +
                                       "\n操作数组：" + ','.join(map(str, numbers)))
                    else:
                        print("无数据进行统计")
                elif stat_operation.lower() == 'avg':
                    if numbers:
                        avg_value = sum(numbers) / len(numbers)
                        print(f"平均值：{avg_value}")
                        # 记录数据统计操作到历史记录中
                        history.append(f"数据统计操作：平均值 = {avg_value}" +
                                       " \n操作时间：" + dt.datetime.now().strftime('%Y-%m-%d  %H:%M:%S') +
                                       "\n操作数组：" + ','.join(map(str, numbers)))
                    else:
                        print("无数据进行统计")
                else:
                    print("无效的统计操作")
            continue

        try:
            # 替换^符号为**来进行乘方运算
            expression_eval = expression.replace("^", "**")

            # 将sqrt替换为math.sqrt
            expression_eval = expression_eval.replace("sqrt(", "math.sqrt(")

            result = eval(expression_eval)
            if isinstance(result, (int, float)):
                print("结果:", result)
                # 将原始用户输入的表达式添加到历史记录中
                history.append("算式操作：" + expression + " = " + str(result) + " 操作时间：" +
                               dt.datetime.now().strftime('%Y-%m-%d  %H:%M:%S'))  # 记录操作时间
            else:
                print("无效的表达式")
        except ZeroDivisionError:
            print("错误：除数不能为零")
        except SyntaxError:
            print("错误：无效的表达式，请检查操作符和括号是否正确")
        except NameError:
            print("错误：操作符或函数未定义，请检查拼写和空格")
        except Exception as e:
            print("发生错误:", str(e))
            continue  # 继续下一次循环，要求用户重新输入


if __name__ == "__main__":
    calculator()
