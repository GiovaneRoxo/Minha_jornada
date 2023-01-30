averageSalary = 0
employeesList = [
                ['Bruno', 1700.00, 3], ['Leonardo', 1400.23, 1], ['Juan', 1561.12, 2], 
                ['Juliana', 1660.07,3], ['Wagner', 1841.92, 5], ['Micaela', 2000.00, 1],
                ['Bento', 1750.87, 4], ['Lucia', 1600.55,1], ['Pedro', 1690.00, 4], 
                ['Carla', 1580.00, 6]
               ]
veteransEmployees = []


for y in range(len(employeesList)):
    averageSalary +=  employeesList[y][1] 

averageSalary = averageSalary / len(employeesList)

for i in range(len(employeesList)):
    if employeesList[i][2] > 3 and employeesList[i][1] > averageSalary:
        veteransEmployees.append(employeesList[i][0])


print('The average salary is: ', averageSalary)
print('The list of veterans employees with more than average salary is: ', veteransEmployees)