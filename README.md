# Jabberpoint
# Systeem Analyse
De systeem analyse is te vinden in het word document "Systeemanalyse.docx". Er is ook een klassendiagram gemaakt van het oude systeem.
# Ontwerp Advies
Het ontwerp advies is te vinden in het word document "Ontwerpadvies.docx"
# Herontwerp
Het herontwerp is te vinden in het word document "Herontwerp.docx". Verder is er een klassendiagram gemaakt van het herontwerp waar de volgende design patterns in zijn geimplementeerd: command pattern, decorator pattern en factory-method pattern.
# OTAP straat
Er is gebruik gemaakt van een OTAP straat om de kwaliteit van de applicatie so hoog mogelijk te houden. Hiervoor is GitHub Actions gebruikt. Met GitHub actions is het mogelijk om sonarcloud te gebruiken. Sonar cloud analyseert de code op fouten en test de code. Op de website van sonarcloud staat een overzicht met alle fouten die in de code zitten.
# Wat is JabberPoint
JabberPoint is een presentatie programma geschreven in de programmeer taal Java.
# Design patterns
### Command pattern
Voor de command pattern is voor elke command een nieuwe klasse gemaakt, boven al deze klasse staat vervolgens een interface die gebruikt wordt in de presentation om de commands uit te voeren.
### Factory method
Bij de factory method is er een nieuwe abstracte klasse aangemaakt namelijk de SlideItemFactory deze extend vervolgens naar BitmapItemFactory en TextItemFactory waar in een nieuwe BitmapItem of TextItem wordt aangemaakt. De SlideItemFactory krijgt een level en informatie mee als hij gebruikt wordt waarbij de informatie afhankelijk is van de gemaakte SlideItem, bij een TextItem is het de text en bij een BitmapItem is het de filepath. De Factories kunnen vervolgens gebruikt worden in andere klasses om de SlideItems aan te maken.
### Decorator pattern
De decorator pattern is nog niet geimplementeerd in JabberPoint
# Principles
### Single-Responsibility Principle
Het single-responsibility principle is toegepast door de factory method. Door BitmapItemCreater en TextItemCreator in aparte klasses te doen wordt er voor gezorgd dat de klasses maar 1 taak hebben.  
### Open-Closed Principle
Het open-closed principle is toegepast door de command pattern. Het is nu makkelijk om nieuwe commando's toe te voegen en je hoeft niet meer de hele broncode aan te passen van MenuController en KeyController.
### Liskov Substitution Principle
Het liskov substitution principle is toegepast door de command pattern door op de juiste manier gebruik te maken van een interface. 

