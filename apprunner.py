import subprocess
import os
import sys

def build():
    print("==== Compilation des projets ====\n")
    subprocess.call(["make"])

def runProjectWindows(os):
    print("\n==== Lancement des hotels ====")
    subprocess.Popen(["make" ,"pHotel"],creationflags=subprocess.CREATE_NEW_CONSOLE)
    subprocess.Popen(["make" ,"pHotel2"],creationflags=subprocess.CREATE_NEW_CONSOLE)
    print("\n==== Lancement des Agences ====")
    if(os==1):
        subprocess.Popen(["make" ,"pAgenceinterface"],creationflags=subprocess.CREATE_NEW_CONSOLE)
        subprocess.Popen(["make" ,"pAgence2interface"],creationflags=subprocess.CREATE_NEW_CONSOLE)
    else:
        subprocess.Popen(["make" ,"pAgenceSimple"],creationflags=subprocess.CREATE_NEW_CONSOLE)
        subprocess.Popen(["make" ,"pAgence2Simple"],creationflags=subprocess.CREATE_NEW_CONSOLE)
    
    if(os==2):
        print("\n==== Lancement du Comparateur ====")
        subprocess.Popen(["make" ,"pComparateur"])

def runProjectLinux(os):
    print("\n==== Lancement des hotels ====")
    command="make pHotel" 
    os.system("gnome-terminal -- bash -c 'bash -c \""+command+";bash\"'")

    command="make pHotel2"
    os.system("gnome-terminal -- bash -c 'bash -c \""+command+";bash\"'")
    
    print("\n==== Lancement des Agences ====")
    if(os==1):
        command="make pAgenceSimple"
        os.system("gnome-terminal -- bash -c 'bash -c \""+command+";bash\"'")
        command="make pAgence2Simple"
        os.system("gnome-terminal -- bash -c 'bash -c \""+command+";bash\"'")
    else:
        command="make pAgenceinterface"
        os.system("gnome-terminal -- bash -c 'bash -c \""+command+";bash\"'")
        command="make pAgence2interface"
        os.system("gnome-terminal -- bash -c 'bash -c \""+command+";bash\"'")
    if(os==2):
        print("\n==== Lancement du Comparateur ====")
        command="make pComparateur"
        os.system("gnome-terminal -- bash -c 'bash -c \""+command+";bash\"'")
    
build()  

myOs=0
print("Voulez vous utiliser les agences ou le comparateur\n")
while True:
    try:
        print("\t 1 - Agence")
        print("\t 2 - Comparateur")
        myOs = int(input("\n Votre choix: "))
    except ValueError:
        print("Valeur indisponible")
        continue
    else:
        if(myOs == 1 or myOs == 2):
            break
        else:
            print("Valeur indisponnible")

if sys.platform.startswith("linux"):  # could be "linux", "linux2", "linux3", ...
    # linux
    runProjectLinux(myOs)
elif sys.platform == "win32":
    runProjectWindows(myOs)