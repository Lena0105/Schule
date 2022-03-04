import math
import time

def f(x):
    return math.sin(x)+0.2

def wertetabelle(funk, xvon, xbis):
    print("x\ty")
    for x in range(xvon,xbis-1):
        print(x, "\t", funk(x))

wertetabelle(f, 0, 12)

def nullstelle(funk, xvon, xbis):
    x = xvon
    y = funk(x)
    vorzeichen = y > 0
    while x <= xbis:
        y = funk(x)
        if y == 0:
            print("Nullstelle gefunden bei x=", x)
            return
        if vorzeichen != (y > 0):
            print ("Nullstelle bei x=", x)
            return
        x+=0.0001
    print("Keine Nullstelle gefunden")

nullstelle(f, 3, 4)
nullstelle(f, 6, 7)
nullstelle(f, 9, 10)

start = time.time()
print("Verstrichene Zeit:")
end = time.time()
print(end - start)
