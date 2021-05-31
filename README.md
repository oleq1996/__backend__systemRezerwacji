# System rezerwacji miejsc w kinie (backend)
System oparty o architekturę klient-serwer. Umożliwia użytkownikowi zarezerwowanie miejsca w kinie na dany seans oraz wysłanie potwierdzenia rezerwacji w postaci pliku .pdf na podany adres e-mail. 

## Wykorzystane technologie/języki
  * Java 
  * Spring Boot
  * Maven
  * PostgreSQL
  * JPA/Hibernate
  * JavaMail
  * iText

## Endpointy
* cinema/date (GET)
* cinema/videos (GET)
* cinema/videos/{videoId} (GET)
* cinema/playing (GET)
* cinema/playing/{date} (GET)
* cinema//reservations (GET)
* cinema/reservations (POST, wymagane body)
* cinema/reservations/{playingId} (GET)
* cinema/seats (GET)

## Projekt bazy danych

![image](https://user-images.githubusercontent.com/56149109/120230203-22fad180-c24f-11eb-8748-994d950a6932.png)
