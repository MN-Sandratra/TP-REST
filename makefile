ifdef OS
   SP = &&
   FixPath = $(subst /,\,$1)
else
   ifeq ($(shell uname), Linux)
      SP = ;
      FixPath = $1
   endif
endif

compile :
	(cd Hotel $(SP) mvn clean install -DskipTests)
	(cd HotelMontpellier $(SP) mvn clean install -DskipTests)
	(cd Agence $(SP) mvn clean install -P profile1 -DskipTests)
	(cd Agence2 $(SP) mvn clean install -P profile1 -DskipTests)
	(cd comparateur $(SP) mvn clean install -P interface -DskipTests)

pHotel :
	(cd Hotel $(SP) mvn spring-boot:run)
	
pHotel2 :
	(cd HotelMontpellier $(SP) mvn spring-boot:run)

pAgenceSimple :
	(cd Agence $(SP) mvn spring-boot:run -P profile1)
	
pAgenceinterface :
	(cd Agence $(SP) mvn spring-boot:run -P profile2)
	
pAgence2Simple :
	(cd Agence2 $(SP) mvn spring-boot:run -P profile1)
	
pAgence2interface :
	(cd Agence2 $(SP) mvn spring-boot:run -P profile2)

pComparateur :
	(cd comparateur $(SP) mvn spring-boot:run)
