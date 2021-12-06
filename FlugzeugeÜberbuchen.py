import random


def wievieleKommen(tickets):
    ergebnis = 0
    for i in range(tickets):
        wahrscheinlichkeit = random.random()
        if(wahrscheinlichkeit < 0.95):
            ergebnis += 1
    return ergebnis

def gewinnFuerFlugzeug(tickets):
    zuVieleTickets = tickets > 200
    #feststellen, wie viele von den verkauften Tickets auch kommen
    passagiere = wievieleKommen(tickets)
    #TODO: Den Gewinn berechnen!
    # fuer jedes verkaufte Ticket: 100 Gewinn
    # fuer jeden passagier ueber 200: 300 Verlust (ggf. 400 abziehen)
    gewinn = tickets*100
    if(passagiere>200):
        gewinn -= zuVieleTickets*400
    return gewinn
    
def durchschnittsGewinn(tickets,versuche):
    #TODO
    # versuche-mal die Funktion gewinnFuerFlugzeug aufrufen
    # dann den Durchschnitt berechnen
    # und zurueckgeben (statt -11)
    ergebnis = gewinnFuerFlugzeug(tickets)/ versuche
    return ergebnis

def ticketzahlenAusprobieren(anfang,ende):
    for tickets in range(anfang,ende):
        #TODO
        #den Durchschnittsgewinn berechnen fuer die tickets
        #dabei 1000 versuche nehmen
        #die -1 in der naechsten Zeile geeignet ersetzen
        durchschnittsGew = durchschnittsGewinn(tickets, 1000)
        print("Tickets:",tickets,"Durchschnittsgewinn:",durchschnittsGew)
        

#main
leuteAmFlughafen = wievieleKommen(205)
print("von 205 kommen",leuteAmFlughafen)
gewinn = gewinnFuerFlugzeug(205)
durchschnittsGew = durchschnittsGewinn(205,1000)
print("Durchschnittsgewinn fÃ¼r 205 Tickets",durchschnittsGew)
print("*******")
ticketzahlenAusprobieren(200,220)
