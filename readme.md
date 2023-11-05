Aplikacja służy do zapisywania przepisów i pobierania listy zakupów.

Powstała przy użyciu języka Java, Spring Boot, Spring Framework, MySQL.

Spring został wykorzystany ze względu na swoją popularność jak i uniwersalność,
dzięki której można go wykorzystać w niemal każdej aplikacji. Dzięki niemu kod
jest zwięzły i czytelny. Zawiera także gotowe moduły do różnych integracji:
np. do pracy z danymi.
Spring pozwolił wykorzystać swoje możliwości w ramach łatwego wykonania testów.

Do uruchomienia aplikacji wymagane jest :
- Java 20
- Maven 3.9.3
- MySQL.
Kod bazy danych znajduję się w pliku "database.sql"
Uruchomić kod można przez umieszczenie kodu z pliku w kliencie bazy MySQL.

Do zrobienia zostało m.in:
- generowanie listy zakupów - usprawnienie pracy z aplikacją
- refaktoring ropozytoriów do JpaRepository - pozwala na usunięcie implementacji
  warstwy DAO. Dzięki temu, rozbudowywująć interfejs, uzyskane zostaną bardziej
  odpowiednie metody CRUD dla standardowego dostępu do danych które są udostępniane
  w standardowym DAO.