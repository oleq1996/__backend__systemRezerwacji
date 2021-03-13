## Pierwsza aplikacja testowa

Aplikacja pobiera dane z bazy danych na serwerze uczelnianym i zwraca je wszystkie.

Pliki wykonywalne .jar znajdują się w folderze jar'y

Uruchomienie:
  * wpisujemy w konsoli w lokalizacji pliku .jar:
    * java -jar nazwa_pliku.jar
  * po uruchomieniu spring-boota wchodzimy w przeglądarce pod endpoint:
    * localhost:8081/cinema/getAll

Jeśli wszystko zadziałało poprawnie powinniśmy dostać listę danych o filmach w formacie .json

![image](https://user-images.githubusercontent.com/56149109/111038655-82083180-842a-11eb-8bd5-8ed5a7a22896.png)
