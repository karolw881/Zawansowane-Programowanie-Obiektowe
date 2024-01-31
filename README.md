# Zawansowane-Programowanie-Obiektowe
Projekt przeznaczony na Zaawansowane Programowanie obiektowe 

# Projekt Gry

To repozytorium zawiera kod źródłowy prostego projektu gry w języku Java. Korzystano z wersji Javy 17.02 

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

```bash
javac Jumper.java
java Jumper

