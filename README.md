# exercism

My solutions to the [Exercism](https://exercism.org/profiles/iulian640) Java track. Each exercise is an independent Gradle project downloaded with the Exercism CLI, solved by hand, and pushed here so the work is visible in one place.

## Java track

| Folder | Exercise | Topics | Status |
|--------|----------|--------|--------|
| [`java/hello-world/`](java/hello-world/) | Hello World | Methods, return values | Done |
| [`java/lasagna/`](java/lasagna/) | Lasagna | Method parameters, arithmetic, calling one method from another | Done |
| [`java/annalyns-infiltration/`](java/annalyns-infiltration/) | Annalyn's Infiltration | Booleans, `!`, `&&`, `||`, static methods | Done |
| [`java/cars-assemble/`](java/cars-assemble/) | Cars, Assemble! | Constants, `if / else if / else`, `int` vs `double`, casting | Done |
| [`java/log-levels/`](java/log-levels/) | Log Levels | Strings, `indexOf`, `substring`, `trim`, `toLowerCase` | Done |
| [`java/salary-calculator/`](java/salary-calculator/) | Salary Calculator | Ternary operator, booleans, reusing methods | Done |
| [`java/bird-watcher/`](java/bird-watcher/) | Bird Watcher | Arrays, `for` and for-each loops, defensive copy | Done |
| [`java/karls-languages/`](java/karls-languages/) | Karl's Languages | `List`, `ArrayList` | Done |
| [`java/jedliks-toy-car/`](java/jedliks-toy-car/) | Jedlik's Toy Car | Classes, fields, static factory method, `StringBuilder` | Done |
| [`java/squeaky-clean/`](java/squeaky-clean/) | Squeaky Clean | `char`, `Character` methods, `StringBuilder`, string replacement | Done |
| [`java/need-for-speed/`](java/need-for-speed/) | Need for Speed | Constructors, state, objects working together | Done |
| [`java/football-match-reports/`](java/football-match-reports/) | Football Match Reports | `switch` with grouped cases, `default` | Done |
| [`java/remote-control-competition/`](java/remote-control-competition/) | Remote Control Competition | Interfaces, `Comparable`, `Collections.sort` | Done |

## How I solved each one

### Hello World
One method, one return. The point of the exercise is the tooling: download with the CLI, run the tests with Gradle, submit.

### Lasagna
Four small methods. `remainingMinutesInOven` reuses `expectedMinutesInOven()` instead of repeating the literal 40, so the constant lives in one place.

### Annalyn's Infiltration
Each method is a boolean expression, no `if`. `canFreePrisoner` is the long one: I wrote out every combination of awake/asleep and dog present/absent that allows the rescue and joined them with `||`. It works, but it could be simplified to two cases (dog present and archer asleep, or prisoner awake and everyone else asleep).

### Cars, Assemble!
The assembly line has a speed from 0 to 10 and a success rate that drops as speed goes up. I put every threshold and rate in a `private static final` constant so there are no magic numbers in the method. Things I got wrong along the way and fixed:

- The `if / else if` chain needs a final `else` (or a trailing `return`), otherwise the compiler complains that the method does not always return a value.
- With thresholds that are upper bounds, the comparison is `<=`, and the lower bound has to be checked before the higher one.
- The rate is per unit of speed: `221 * speed * successRate`, not just `221 * successRate`.
- `productionRatePerHour` must return a `double`. `workingItemsPerMinute` returns an `int` and truncates, so a plain `(int)` cast is what the exercise expects, not `Math.round`. Watch the parentheses: `(int) x / 60` casts first and then does integer division, `(int) (x / 60)` divides first. Both give the same result here, but they are not the same operation.

### Log Levels
A log line looks like `[ERROR]: Disk full`. `message` cuts everything after the `:` and trims the spaces, `logLevel` takes what sits between `[` and `]` and lowercases it. `reformat` doesn't parse anything again: it calls the other two and glues the result as `Disk full (error)`.

### Salary Calculator
Every rule is a single ternary: a penalty if you skip 5 days or more, a bigger bonus from 20 products sold, and a cap of 2000 on the final salary. `finalSalary` builds on `salaryMultiplier` and `bonusForProductsSold` instead of repeating their logic.

### Bird Watcher
The constructor stores a copy of the array (`clone()`), so whoever creates the object can't change my counts from outside. For "is there a day without birds" and "how many busy days" I used a for-each. For the first N days I needed the index, so a classic `for` with `Math.min(numberOfDays, 7)` to avoid running past the end of the week.

### Karl's Languages
A thin wrapper around an `ArrayList<String>`. Almost every method is one line that delegates to the list (`add`, `remove`, `get(0)`, `size`, `contains`). `isExciting` is true if the list has Java or Kotlin.

### Jedlik's Toy Car
First exercise with object state: the car keeps its battery and meters driven, and `drive()` only moves it while there is battery left. `buy()` is a static method that returns a new car. I built the display texts with `StringBuilder`, which is more than this needs; plain concatenation would do the same job.

### Squeaky Clean
`clean` runs in two steps. First the simple replacements on the whole string: spaces become `_` and the leetspeak digits go back to letters (`4` to `a`, `3` to `e`, `0` to `o`, `1` to `l`, `7` to `t`). Then I walk the characters one by one: a `-` is dropped and turns the next letter into uppercase (kebab-case to camelCase), and anything that is not a letter or `_` is skipped.

### Need for Speed
Two classes that work together. `NeedForSpeed` is the car, with its speed, battery drain and a `nitro()` factory for the fast model. `RaceTrack` decides if a car can finish: number of drives needed times battery drain, compared to 100. This one took me a few days. One thing I still want to fix: I call `Math.ceil` on the distance and on the speed, but both are already whole numbers, so it does nothing. The rounding should go on the result of the division.

### Football Match Reports
Shirt number to position with a `switch`. Numbers that share a position go in the same case (`case 3, 4`, `case 6, 7, 8`), and `default` returns `"invalid"` for anything else.

### Remote Control Competition
`RemoteControlCar` is an interface with `drive()` and `getDistanceTravelled()`, and two cars implement it with different speeds. `TestTrack.race` accepts any of them because it only knows the interface. For the ranking, `ProductionRemoteControlCar` implements `Comparable` and orders by victories, most first (`other - this`), so `Collections.sort` does the rest.

## How to run the tests of an exercise

```bash
cd java/<exercise-folder>
./gradlew test
```

## Submitting to Exercism

```bash
cd java/<exercise-folder>
exercism submit src/main/java/*.java
```
