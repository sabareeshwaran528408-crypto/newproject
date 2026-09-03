import os

FILE_NAME = "students.txt"


# ---------------------------------------------------------
# Function to add a new student
# ---------------------------------------------------------
def add_student():
    print("\n========== ADD STUDENT ==========")

    try:
        roll_no = int(input("Enter Roll Number: "))
        name = input("Enter Student Name: ")
        age = int(input("Enter Age: "))
        department = input("Enter Department: ")
        mark1 = float(input("Enter Mark 1: "))
        mark2 = float(input("Enter Mark 2: "))
        mark3 = float(input("Enter Mark 3: "))

        total = mark1 + mark2 + mark3
        average = total / 3

        if average >= 90:
            grade = "A+"
        elif average >= 80:
            grade = "A"
        elif average >= 70:
            grade = "B"
        elif average >= 60:
            grade = "C"
        elif average >= 50:
            grade = "D"
        else:
            grade = "F"

        student = (
            f"{roll_no}|{name}|{age}|{department}|"
            f"{mark1}|{mark2}|{mark3}|"
            f"{total:.2f}|{average:.2f}|{grade}\n"
        )

        with open(FILE_NAME, "a") as file:
            file.write(student)

        print("\nStudent added successfully!")

    except ValueError:
        print("\nInvalid input! Please enter the correct data.")


# ---------------------------------------------------------
# Function to display all students
# ---------------------------------------------------------
def display_students():
    print("\n========== STUDENT DETAILS ==========")

    if not os.path.exists(FILE_NAME):
        print("No student records found.")
        return

    with open(FILE_NAME, "r") as file:
        records = file.readlines()

    if len(records) == 0:
        print("No student records found.")
        return

    for record in records:
        data = record.strip().split("|")

        if len(data) == 10:
            print("\n----------------------------------------")
            print("Roll Number :", data[0])
            print("Name        :", data[1])
            print("Age         :", data[2])
            print("Department  :", data[3])
            print("Mark 1      :", data[4])
            print("Mark 2      :", data[5])
            print("Mark 3      :", data[6])
            print("Total       :", data[7])
            print("Average     :", data[8])
            print("Grade       :", data[9])
            print("----------------------------------------")


# ---------------------------------------------------------
# Function to search student
# ---------------------------------------------------------
def search_student():
    print("\n========== SEARCH STUDENT ==========")

    try:
        roll_no = int(input("Enter Roll Number to Search: "))
    except ValueError:
        print("Invalid Roll Number!")
        return

    if not os.path.exists(FILE_NAME):
        print("No records found.")
        return

    found = False

    with open(FILE_NAME, "r") as file:
        for record in file:
            data = record.strip().split("|")

            if len(data) == 10 and int(data[0]) == roll_no:
                print("\nStudent Found!")
                print("-----------------------------")
                print("Roll Number :", data[0])
                print("Name        :", data[1])
                print("Age         :", data[2])
                print("Department  :", data[3])
                print("Mark 1      :", data[4])
                print("Mark 2      :", data[5])
                print("Mark 3      :", data[6])
                print("Total       :", data[7])
                print("Average     :", data[8])
                print("Grade       :", data[9])
                print("-----------------------------")

                found = True
                break

    if not found:
        print("Student not found.")


# ---------------------------------------------------------
# Function to update student
# ---------------------------------------------------------
def update_student():
    print("\n========== UPDATE STUDENT ==========")

    try:
        roll_no = int(input("Enter Roll Number to Update: "))
    except ValueError:
        print("Invalid Roll Number!")
        return

    if not os.path.exists(FILE_NAME):
        print("No records found.")
        return

    with open(FILE_NAME, "r") as file:
        records = file.readlines()

    found = False

    for i in range(len(records)):
        data = records[i].strip().split("|")

        if len(data) == 10 and int(data[0]) == roll_no:

            print("\nCurrent Student Details")
            print("Name       :", data[1])
            print("Age        :", data[2])
            print("Department :", data[3])

            try:
                name = input("Enter New Name: ")
                age = int(input("Enter New Age: "))
                department = input("Enter New Department: ")

                mark1 = float(input("Enter New Mark 1: "))
                mark2 = float(input("Enter New Mark 2: "))
                mark3 = float(input("Enter New Mark 3: "))

                total = mark1 + mark2 + mark3
                average = total / 3

                if average >= 90:
                    grade = "A+"
                elif average >= 80:
                    grade = "A"
                elif average >= 70:
                    grade = "B"
                elif average >= 60:
                    grade = "C"
                elif average >= 50:
                    grade = "D"
                else:
                    grade = "F"

                records[i] = (
                    f"{roll_no}|{name}|{age}|{department}|"
                    f"{mark1}|{mark2}|{mark3}|"
                    f"{total:.2f}|{average:.2f}|{grade}\n"
                )

                found = True
                break

            except ValueError:
                print("Invalid input!")
                return

    if found:
        with open(FILE_NAME, "w") as file:
            file.writelines(records)

        print("Student updated successfully!")

    else:
        print("Student not found.")


# ---------------------------------------------------------
# Function to delete student
# ---------------------------------------------------------
def delete_student():
    print("\n========== DELETE STUDENT ==========")

    try:
        roll_no = int(input("Enter Roll Number to Delete: "))
    except ValueError:
        print("Invalid Roll Number!")
        return

    if not os.path.exists(FILE_NAME):
        print("No records found.")
        return

    with open(FILE_NAME, "r") as file:
        records = file.readlines()

    new_records = []
    found = False

    for record in records:
        data = record.strip().split("|")

        if len(data) == 10 and int(data[0]) == roll_no:
            found = True
        else:
            new_records.append(record)

    if found:
        with open(FILE_NAME, "w") as file:
            file.writelines(new_records)

        print("Student deleted successfully!")

    else:
        print("Student not found.")


# ---------------------------------------------------------
# Function to find class average
# ---------------------------------------------------------
def class_average():
    print("\n========== CLASS AVERAGE ==========")

    if not os.path.exists(FILE_NAME):
        print("No records found.")
        return

    total_average = 0
    count = 0

    with open(FILE_NAME, "r") as file:
        for record in file:
            data = record.strip().split("|")

            if len(data) == 10:
                total_average += float(data[8])
                count += 1

    if count > 0:
        average = total_average / count
        print("Number of Students :", count)
        print("Class Average      :", round(average, 2))
    else:
        print("No valid student records.")


# ---------------------------------------------------------
# Function to display top student
# ---------------------------------------------------------
def top_student():
    print("\n========== TOP STUDENT ==========")

    if not os.path.exists(FILE_NAME):
        print("No records found.")
        return

    highest_average = -1
    student_data = None

    with open(FILE_NAME, "r") as file:
        for record in file:
            data = record.strip().split("|")

            if len(data) == 10:
                average = float(data[8])

                if average > highest_average:
                    highest_average = average
                    student_data = data

    if student_data is not None:
        print("\nTop Student")
        print("-----------------------------")
        print("Roll Number :", student_data[0])
        print("Name        :", student_data[1])
        print("Department  :", student_data[3])
        print("Average     :", student_data[8])
        print("Grade       :", student_data[9])
        print("-----------------------------")
    else:
        print("No student records.")


# ---------------------------------------------------------
# Function to count grades
# ---------------------------------------------------------
def grade_statistics():
    print("\n========== GRADE STATISTICS ==========")

    grades = {
        "A+": 0,
        "A": 0,
        "B": 0,
        "C": 0,
        "D": 0,
        "F": 0
    }

    if not os.path.exists(FILE_NAME):
        print("No records found.")
        return

    with open(FILE_NAME, "r") as file:
        for record in file:
            data = record.strip().split("|")

            if len(data) == 10:
                grade = data[9]

                if grade in grades:
                    grades[grade] += 1

    for grade, count in grades.items():
        print(f"Grade {grade} : {count} student(s)")


# ---------------------------------------------------------
# Main Menu
# ---------------------------------------------------------
def main():
    while True:

        print("\n")
        print("==========================================")
        print("       STUDENT MANAGEMENT SYSTEM")
        print("==========================================")
        print("1. Add Student")
        print("2. Display All Students")
        print("3. Search Student")
        print("4. Update Student")
        print("5. Delete Student")
        print("6. Class Average")
        print("7. Top Student")
        print("8. Grade Statistics")
        print("9. Exit")
        print("==========================================")

        choice = input("Enter your choice: ")

        if choice == "1":
            add_student()

        elif choice == "2":
            display_students()

        elif choice == "3":
            search_student()

        elif choice == "4":
            update_student()

        elif choice == "5":
            delete_student()

        elif choice == "6":
            class_average()

        elif choice == "7":
            top_student()

        elif choice == "8":
            grade_statistics()

        elif choice == "9":
            print("\nThank you for using the Student Management System!")
            break

        else:
            print("\nInvalid choice! Please select 1-9.")


# ---------------------------------------------------------
# Program starts here
# ---------------------------------------------------------
if __name__ == "__main__":
    main()1