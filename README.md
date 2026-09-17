# exercism

My solutions to the [Exercism](https://exercism.org/profiles/iulian640) Java track. Each exercise is an independent Gradle project downloaded with the Exercism CLI, solved by hand, and pushed here so the work is visible in one place.

## Java track

| Folder | Exercise | Topics | Status |
|--------|----------|--------|--------|
| [`java/hello-world/`](java/hello-world/) | Hello World | Methods, return values | Done |
| [`java/lasagna/`](java/lasagna/) | Lasagna | Method parameters, arithmetic, calling one method from another | Done |
| [`java/annalyns-infiltration/`](java/annalyns-infiltration/) | Annalyn's Infiltration | Booleans, `!`, `&&`, `||`, static methods | Done |
| [`java/cars-assemble/`](java/cars-assemble/) | Cars, Assemble! | Constants, `if / else if / else`, `int` vs `double`, casting | Done |

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
