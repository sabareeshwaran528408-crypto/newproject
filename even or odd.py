try:
    number = int(input("Enter a number: "))
    if number % 2 == 0:
        print("Even number")
    else:
        print("Odd number")
except ValueError:
    print("Please enter a whole number.")
    print("hi")
