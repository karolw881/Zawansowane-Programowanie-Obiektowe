# Zawansowane-Programowanie-Obiektowe
Projekt przeznaczony na Zaawansowane Programowanie obiektowe 

# Java Game

To repozytorium zawiera kod źródłowy projektu gry w języku Java. Korzystano z wersji Javy 17.02 


## Używane Biblioteki

### 1. `java.awt.*` (Abstract Window Toolkit)
   - Klasy i interfejsy do tworzenia interfejsów użytkownika oraz obsługi grafiki.

### 2. `java.awt.event.*`
   - Obsługa zdarzeń (eventów) w AWT, umożliwia interakcję użytkownika.

### 3. `javax.swing.*`
   - Zaawansowane komponenty interfejsu graficznego użytkownika (GUI).

### 4. `java.io.File`
   - Manipulacja plikami, odczyt, zapis, sprawdzanie istnienia itp.

### 5. `java.io.IOException`
   - Wyjątek dla problemów z operacjami wejścia/wyjścia.

### 6. `java.nio.charset.StandardCharsets`
   - Standardowe kodowania znaków używane w operacjach wejścia/wyjścia.

### 7. `java.nio.file.Files` i `java.nio.file.Paths`
   - Operacje na plikach i katalogach w sposób zaawansowany.

### 8. `java.nio.file.StandardOpenOption`
   - Opcje otwarcia pliku w operacjach wejścia/wyjścia.

### 9. `java.util.ArrayList`
   - Implementacja dynamicznej tablicy dla elastycznego zarządzania elementami.

### 10. `java.util.Iterator`
    - Interfejs do iteracji po elementach kolekcji.

### 11. `java.util.Random`
    - Generowanie pseudolosowych liczb.

### 12. `javax.imageio.ImageIO`
    - Operacje związane z obsługą obrazów, takie jak odczyt i zapis.

### 13. `java.awt.event.ActionEvent` i `java.awt.event.ActionListener`
    - Obsługa zdarzeń związanych z akcjami użytkownika.

### 14. `java.io.*`
    - Klasy związane z operacjami wejścia/wyjścia, takie jak strumienie danych.

### 15. `java.awt.Graphics` i `javax.swing.JPanel`
    - Rysowanie na komponentach graficznych, np. na panelu w aplikacji Swing.



# Jumper - Gra Platformowa w Javie

Jumper to  gra platformowa napisana w języku Java przy użyciu bibliotek AWT i Swing. Celem gracza jest unikanie przeszkód, zbieranie punktów oraz unikanie strzałów przeciwników.

## Zasady Gry

- **Sterowanie:**
  - Skok: `Spacja` lub `Strzałka w górę`
  - Strzał: `Z`
  - Ruch w prawo: `Strzałka w prawo`

- **Cel gry:**
  - Unikaj przeszkód i przeciwników.
  - Zbieraj punkty poprzez zebranie punktów (Collectible).
  - Strzelaj wrogom, aby zdobywać dodatkowe punkty.
  - Gra kończy się, gdy postać gracza zderzy się z przeszkodą lub przeciwnikiem.
  - Wytzymaj jak najdłóżej bez zderzenia się z przeszkodą lub przeciwnikiem i zdobywaj jak najwięcej punktów zestrzelając przeciwnika i zbierajac punkty . 
- **Punktacja:**
  - Zebranie punktu: +10 punktów
  - Zestrzelenie wroga: +10 punktów

- **Restart Gry:**
  - Gra może zostać zrestartowana po zakończeniu poprzez naciśnięcie przycisku "Play Again".
 


## Wymagania

- JRE (Java Runtime Environment) do uruchomienia gry.

## Uruchomienie Gry

1. Skompiluj i uruchom grę, używając komendy:
   ```bash
   javac Jumper.java
   java Jumper


## Uruchomienie z GitHuba w IntelliJ IDEA

2. ## Uruchomienie z GitHuba w IntelliJ IDEA

 **Pobierz Projekt:**
   Sklonuj lub pobierz repozytorium gry z GitHuba na swój lokalny komputer.

   bash
   git clone https://github.com/TWOJA_NAZWA_REPOZYTORIUM/Jumper.git
Otwórz Projekt w IntelliJ IDEA:

Uruchom IntelliJ IDEA.
Wybierz opcję "Open" i wybierz katalog, w którym znajduje się projekt Jumper.
Uruchomienie Klasy Jumper:

Znajdź klasę Jumper.java w drzewie projektu.
Kliknij prawym przyciskiem myszy na klasie Jumper.java.
Wybierz opcję "Run 'Jumper

   
# Jumper - Gra Platformowa w Javie

Jumper to prosta gra platformowa napisana w języku Java przy użyciu bibliotek AWT i Swing. Celem gracza jest unikanie przeszkód, zbieranie punktów oraz unikanie strzałów przeciwników.

## Zasady Gry

- **Sterowanie:**
  - Skok: `Spacja` lub `Strzałka w górę`
  - Strzał: `Z`
  - Ruch w prawo: `Strzałka w prawo`

- **Cel gry:**
  - Unikaj przeszkód i przeciwników.
  - Zbieraj punkty poprzez zebranie punktów (Collectible).
  - Strzelaj wrogom, aby zdobywać dodatkowe punkty.
  - Gra kończy się, gdy postać gracza zderzy się z przeszkodą lub przeciwnikiem.

- **Punktacja:**
  - Zebranie punktu: +10 punktów
  - Zestrzelenie wroga: +10 punktów

- **Restart Gry:**
  - Gra może zostać zrestartowana po zakończeniu poprzez naciśnięcie przycisku "Play Again".

## Wymagania

- JRE (Java Runtime Environment) do uruchomienia gry.



   
## Klasy:

### Bullet
Klasa reprezentująca pociski w grze.

### Collectible
Klasa reprezentująca zbieralne przedmioty w grze.

### Enemy
Klasa reprezentująca wrogów w grze.

### Enemy2
Klasa reprezentująca konkretny rodzaj wroga z dodatkową funkcjonalnością.

### EnemyBullet
Klasa reprezentująca pociski wystrzeliwane przez wrogów.

### Jumper
Główna klasa do uruchamiania gry.

### LaunchPage
Klasa reprezentująca stronę startową gry z przyciskami startu, wysokich wyników i wyjścia.

### Player
Klasa reprezentująca postać gracza w grze.

### Renderer
Klasa odpowiedzialna za renderowanie komponentów gry.

### Result
Klasa implementująca interfejs Comparable do reprezentowania wyników gry, z niestandardowym algorytmem sortowania opartym na kombinacji punktów i czasu.

## Główna Klasa - Jumper

Klasa `Jumper` jest główną klasą w projekcie gry. Odpowiada za logikę gry, obsługę zdarzeń klawiatury, oraz renderowanie elementów na ekranie.

### Właściwości:

- `WIDTH`, `HEIGHT`: Szerokość i wysokość okna gry.
- `ENEMY_SIZE`, `ENEMY2_SIZE`, `POINT_SIZE`: Rozmiary różnych elementów gry.
- `renderer`: Obiekt klasy `Renderer` odpowiedzialnej za renderowanie.
- `columns`, `bullets`, `enemyBullets`, `collecter`: Listy przechowujące kolumny, pociski, strzały wrogów i przedmioty zbieralne.
- `ticks`, `yMotion`, `score`: Liczniki, prędkość poruszania się w pionie postaci, oraz wynik gracza.
- `gameOver`, `started`: Flagi informujące o stanie gry.
- `rand`: Obiekt klasy `Random` do generowania losowych wartości.
- `groundImage`, `playerImage`, `evilImage`, `devilImage`, `collectibleImage`: Obrazy używane w grze.
- `enemy`, `enemy2`, `player`, `collectible`: Obiekty reprezentujące wroga, gracza i przedmiot zbieralny.
- `backgrounds`, `backgroundXCoordinates`: Listy przechowujące obrazy tła i ich współrzędne.

### Metody:

- `repaint(Graphics g)`: Metoda do renderowania elementów gry.
- `main(String[] args)`: Metoda uruchamiająca grę, inicjalizująca klasę `LaunchPage`.
- `paintColumn(Graphics g, Rectangle column)`: Metoda do renderowania kolumny.
- `actionPerformed(ActionEvent e)`: Metoda obsługująca zdarzenia czasowe, np. poruszanie się postaci.
- `jump()`: Metoda obsługująca skok postaci.
- `addColumn(boolean start)`: Metoda dodająca nową kolumnę.
- `shoot()`: Metoda obsługująca strzał gracza.
- `keyPressed(KeyEvent e)`, `keyReleased(KeyEvent e)`, `keyTyped(KeyEvent e)`: Metody obsługujące zdarzenia klawiatury.
- `resetGame()`: Metoda resetująca grę po zakończeniu.
- `initializeBackgrounds()`: Metoda inicjalizująca obrazy tła.
- `enemyShoot(Enemy enemy)`: Metoda obsługująca strzał wroga.

### Inne:

Klasa zawiera konstruktor, który inicjalizuje różne elementy gry, takie jak postać gracza, wrogowie, kolumny, czy obrazy. Dodatkowo, klasa implementuje ActionListener i KeyListener do obsługi zdarzeń czasowych i klawiatury.


## Użycie:

Aby uruchomić grę, wykonaj klasę `Jumper`. Gra wyświetli stronę startową z opcjami rozpoczęcia gry, zobaczenia wysokich wyników lub wyjścia.

Aby zobaczyć wyniki, kliknij przycisk "Wysokie Wyniki" na stronie startowej. Wyniki są odczytywane z pliku, sortowane i wyświetlane w oknie dialogowym.

## Struktura plików:

- `src/`: Zawiera kod źródłowy gry.
- `highscores.txt`: Plik przechowujący wysokie wyniki.


## Uruchamianie Gry:

Skompiluj i uruchom klasę `Jumper`, aby rozpocząć grę.

bash

javac Jumper.java
java Jumper

## Obiektowość w Klasie Jumper

Klasa Jumper została zaprojektowana zgodnie z paradygmatem obiektowości w programowaniu. Oto opis elementów obiektowych w tej klasie:

1. **Koncepcja Obiektu**
   - *Obiekty Klasy:* Obiekt tej klasy reprezentuje główną logikę gry. Jest odpowiedzialny za zarządzanie elementami jak gracz, przeciwnicy, strzały, przeszkody, punkty, obrazy tła, itp.

2. **Encapsulation (Enkapsulacja)**
   - *Pola Prywatne:* Wszystkie pola klasy są zdeklarowane jako prywatne, co oznacza, że są niedostępne z zewnątrz klasy. Dostęp do nich jest możliwy tylko za pomocą publicznych metod.

3. **Inheritance (Dziedziczenie)**
   - *Implementacja Interfejsów:* Klasa Jumper implementuje interfejsy ActionListener i KeyListener, co pozwala na obsługę zdarzeń związanych z akcjami użytkownika.

4. **Polymorphism (Polimorfizm)**
   - *Nadpisywanie Metod:* Kluczowe metody takie jak paintColumn, actionPerformed, jump, shoot, itp., są nadpisywane, co umożliwia dostosowywanie ich do specyfiki gry.

5. ** a takze inne pomocne koncepcje **

   - *Używanie Klas Zewnętrznych:* Klasa Jumper korzysta z wielu innych klas, takich jak Renderer, Player, Enemy, Bullet, Collectible, itp., do zorganizowanego zarządzania różnymi elementami gry.
   - *Listy Obiektów:* Klasa zawiera listy obiektów, takie jak bullets, columns, enemyBullets, które agregują elementy o podobnej funkcji.
   - *Konstruktor Klasy:* Klasa posiada konstruktor Jumper(), który inicjalizuje wiele elementów gry, takich jak obrazy, obiekty przeciwników, gracz, tło, itp.


Te elementy obiektowości sprawiają, że klasa Jumper jest czytelna, modularna i łatwa do utrzymania. Pozwala to na efektywne zarządzanie logiką gry oraz reużywalność kodu.


