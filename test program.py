print("new folder check")
n=str(input("enter your qualification:"))
dept=str(input("enter your deptment:"))
if n=='engineer':
    print("your are engnire")
elif n=='btech':
     print("your are UG student")
elif n=='mtech':
     print("your are PG student")   
else:
    print("you not engineer")
if dept=='aids':
        if n=='btech':
         print("YOUR ARE ELIGBLE")
        else:
         print("other degree student are not elgible")
else:
    print("other deptment student are not elgible")                  