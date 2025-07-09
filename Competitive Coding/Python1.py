def function1(path):
    try:
        path = path[5:]
        return True
    except Exception as e:
        print(e)
        return False
    
flag = function1(path=None)
print(flag)