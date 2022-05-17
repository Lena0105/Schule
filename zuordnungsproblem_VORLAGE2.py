import tkinter as tk
import random as random
import itertools


#taxis = [[244, 195], [98, 416], [150, 57], [242, 239], [378, 367], [359, 92], [198, 217]]
#kunden = [[43, 433], [97, 216], [340, 98], [250, 212], [304, 18], [403, 447], [78, 318]]

taxis = [[244, 195], [98, 416], [150, 57], [242, 239]]
kunden = [[43, 433], [97, 216], [340, 98], [250, 212]]


#abstaende:
#speichert die Abstaende zwischen taxis und kunden
#z.B. abstaende[0][2]: Abstand zwischen Taxi 0 und Kunde 2
abstaende = []

#verbindungen:
#in verbindungen(=eine Liste) wird eingetragen,
# welches Taxi mit welchem Kunden verbunden wird.
# z.B. verbindungen.append([0,2]): Das Taxi 0 wird mit dem Kunden 2 verbunden.
verbindungen = []

distanzen = []

besteGesamtDistanz = 1000000

# Groesse der Leinwand
# in x- und in y-Richtung
leinwandGroesse = 500

def loesungFinden():
    global verbindungen, taxis, kunden,besteGesamtDistanz
    print("loesungFinden")
    print("TODO: verbessern!")
    # TODO
    # Hier wird das 0te Taxi mit dem 0ten Kunden verbunden
    # das 1te Taxi mit dem 1ten Kunden
    # usw.
    somelists = [taxis, kunden]
    neueListe = [[a,b] for a in somelists[0] for b in somelists[1]]
    print (neueListe)
    for i in range(len(taxis)):
        verbindungen.append([i,i])
    gesamtDistanz = berechneGesamtDistanzVerbindungen()
    print("GesamtDistanz: ",gesamtDistanz)
    besteGesamtDistanz = gesamtDistanz

def loesungFinden2():
    global verbindungen, taxis, kunden,besteGesamtDistanz

    testliste = range(len(taxis))
    print("testliste:",testliste)
    permutations = list(itertools.permutations(testliste))
    print()
    print("alle Permuationen von testliste")
    print(permutations)
    print()
    
    print("jetzt jede Permuation einzeln")

    besteVerbindungen = None
    for perm in permutations:
        print(perm)
        indexTaxi = 0
        gesamtDistanz = 0
        alleVerbindungen = []
        for indexKunde in perm:
            print(indexTaxi,"-->",indexKunde)
            alleVerbindungen.append([indexTaxi,indexKunde])
            aktAbstand = abstand(taxis[indexTaxi],kunden[indexKunde])
            gesamtDistanz += aktAbstand
            indexTaxi += 1
        print("GesamtDistanz: ",gesamtDistanz)
        print("alleVerbindungen: ",alleVerbindungen)
        if gesamtDistanz < besteGesamtDistanz:
                besteGesamtDistanz = gesamtDistanz
                besteVerbindungen = alleVerbindungen
    print("BesteGesamtDistanz: ",besteGesamtDistanz)
    print("besteVerbindungen: ",besteVerbindungen)
    verbindungenZeichnen(besteVerbindungen)

    

def loesungFinden3():
    global verbindungen, taxis, kunden,besteGesamtDistanz, abstaende
    for i in range(len(taxis)):
        besteVerbindung = 10000
        schonVergeben = []
        Verbindung = []
        for x in range(len(kunden)):
            aktVerbindung = abstaende([i],[x])
            if aktVerbindung < besteVerbindung:
                besteVerbindung = aktVerbindung
                jetztVergeben = x
                Verbindung.append([i],[x])
        alleVerbindungen.extend(Verbindung)
        schonVergeben.append(jetztVergeben)
                
            
        
     
    

    #ToDo
        
        
        

#mathematische Methoden

# berechnet den Abstand zwischen zwei Punkten
def abstand(punkt1,punkt2):
    x1 = punkt1[0]
    y1 = punkt1[1]
    x2 = punkt2[0]
    y2 = punkt2[1]
    ergebnis = ((((x2 - x1 )**2) + ((y2-y1)**2) )**0.5)
    return ergebnis

# berechnet den Abstand zwischen einem Taxi (gegeben durch den Index) und einem Kunden (gegeben durch den Index)
def abstandTaxiKunde(taxiIndex,kundeIndex):
    global taxis, kunden
    t = taxis[taxiIndex]
    k = kunden[kundeIndex]
    a = abstand(t,k)
    print("Distanz Taxi",taxiIndex,"- Kunde ",kundeIndex,": ",a)
    return a
    
def abstaendeBerechnen():
    global abstaende
    abstaende.clear()
    for p1 in taxis:
        p1_abstaende = []
        for p2 in kunden:
            #print("p1,p2:",p1,p2)
            p1_abstaende.append(abstand(p1, p2))
        abstaende.append(p1_abstaende)
    abstaendeAusgeben()
    

def abstaendeAusgeben():
    #print("abstaende: ",abstaende)
    print("Abstandstabelle (gerundet):")
    for zeile in abstaende:
        zeileGerundet = [round(x) for x in zeile]
        print(zeileGerundet)
    print()

def berechneGesamtDistanzVerbindungen():
    global verbindungen, taxis, kunden
    ergebnis = 0.0
    for v in verbindungen:
        taxiIndex = v[0]
        kundeIndex = v[1]
        a = abstandTaxiKunde(taxiIndex, kundeIndex)
        ergebnis += a
    return ergebnis




#Zufallsvariable initialisieren
random.seed()

# grafische Attribute

taxisIds = []
kundenIds = []
linienIds = []


#grafische Methoden

def linieKoordinaten(x1, y1, x2, y2, color):
    global leinwand
    linie_id = leinwand.create_line(x1,y1,x2,y2,fill=color)
    linienIds.append(linie_id)
    return linie_id

def liniePunkte(p1,p2):
    global leinwand
    return linieKoordinaten(p1[0],p1[1],p2[0],p2[1], "black")
    

def punkt(x, y, color):
    global leinwand
    punkt_id = linieKoordinaten(leinwand, x, y, x+1, y, color)
    return punkt_id

def kreis(x,y, r, color):
    global leinwand
    kreis_id = leinwand.create_oval(x-r,y-r,x+r,y+r, fill=color)
    return kreis_id

def verbindungenZeichnen(verbindungsListe):
    global leinwand, taxis,kunden
    for v in verbindungsListe:
        t = taxis[v[0]]
        k = kunden[v[1]]
        liniePunkte(t,k)

def taxiHinzufuegen(x,y):
        taxis.append([x,y])
        taxisIds.append(kreis(x,y,2,"red"))
    
def kundeHinzufuegen(x,y):
        kunden.append([x,y])
        kundenIds.append(kreis(x,y,2,"blue"))
    
#Callback-Methoden

def leinwandClicked(event):
    x, y = event.x, event.y
    if(sollTaxisZeichnen()):
        taxiHinzufuegen(x, y)
        print("Taxis:",taxis)
    else:
        kundeHinzufuegen(x, y)
        print("Kunden:",taxis)
        
    
def clearClicked():
    for theId in taxisIds:
        leinwand.delete(theId)
    for theId in kundenIds:
        leinwand.delete(theId)
    for theId in linienIds:
        leinwand.delete(theId)
    taxis.clear()
    kunden.clear()
    verbindungen.clear()

def switchTaxisKundenClicked():
    global switchButton
    if(switchButton['text'] == 'Taxis'):
        switchButton['text'] = 'Kunden'
    else:
        switchButton['text'] = 'Taxis'    

def zufallClicked():
    global anzahlEntry
    anzahl = (int)(anzahlEntry.get())
    print("Anzahl:",anzahl)
    clearClicked()
    for i in range(anzahl):
        x = random.randint(5,leinwandGroesse-5)
        y = random.randint(5,leinwandGroesse-5)
        taxiHinzufuegen(x, y)
    for i in range(anzahl):
        x = random.randint(5,leinwandGroesse-5)
        y = random.randint(5,leinwandGroesse-5)
        kundeHinzufuegen(x, y)
        

def sollTaxisZeichnen():
    global switchButton
    return (switchButton['text'] == 'Taxis')

def startClicked():
    global besteGesamtDistanz
    besteGesamtDistanz = 1000000
    print("startClicked")
    print("taxis:")
    print(taxis)
    print("kunden:")
    print(kunden)
    print()
    
    differenzTaxisKunden = len(taxis) - len(kunden)
    if(differenzTaxisKunden != 0):
        print("Es gibt nicht gleich viele Taxis und Kunden!")
        if(differenzTaxisKunden > 0):
            print("Noch",differenzTaxisKunden,"Kunden hinzufuegen")
        else:
            print("Noch",-differenzTaxisKunden,"Taxis hinzufuegen")
        return   

    abstaende.clear()
    verbindungen.clear()
    abstaendeBerechnen()   
    loesungFinden2()
    print("fertig") 


#main
root = tk.Tk(className="Zuordnungsproblem: Taxis-Kunden")
leinwand = tk.Canvas(root, relief = tk.FLAT, background = "#D2D2D2", width=leinwandGroesse,
           height=leinwandGroesse)
leinwand.grid(row=0,column=0)
leinwand.bind('<Button-1>', leinwandClicked)

buttonPane = tk.PanedWindow(orient="horizontal")
buttonPane.grid(row=1,column=0)

#start-Button
tk.Button(
        buttonPane,
        text="start",
        width=10,
        command=startClicked,
    ).grid(row=0, column=0)

#clear-Button
tk.Button(
        buttonPane,
        text="clear",
        width=10,
        command=clearClicked,
    ).grid(row=0, column=1)

#switch-Button
switchButton = tk.Button(
        buttonPane,
        text="Taxis",
        width=10,
        command=switchTaxisKundenClicked,
    )
switchButton.grid(row=0, column=2)

#zufall-Button
tk.Button(
        buttonPane,
        text="Zufall",
        width=10,
        command=zufallClicked,
    ).grid(row=0, column=3)

#anzahl-Entry
anzahlEntry = tk.Entry(buttonPane, width=10, font="Calibri 10")
anzahlEntry.insert(0,"20")
anzahlEntry.grid(row=0,column=4)

#taxis zeichnen
for p in taxis:
    taxisIds.append(kreis(p[0],p[1],2,"yellow"))

for p in kunden:
    kundenIds.append(kreis(p[0],p[1],2,"red"))

root.mainloop()
