# Word Frequency Counter (Java)

A simple program that reads user text and reports word frequencies using `HashMap`, output sorted alphabetically (`TreeMap`).

## Features
- Case-insensitive counting
- Punctuation ignored (letters/digits/apostrophes kept)
- Multi-line input until `exit`
- Summary totals
- (Optional) Swing GUI

## How to Run (CLI)
```bash
javac -d out src/WordFrequencyGUI.java
java -cp out WordFrequencyGUI


---

# 4) Suggested Test Cases (for your demo video)

**Normal cases**
1) `Hello hello HELLO`
   - Expected: `hello: 3`
2) `Java is fun. Java, Java?`
   - Expected: `java: 3`, `is: 1`, `fun: 1`
3) `A cat and a dog; a cat!`
   - Expected: `a: 3`, `and: 1`, `cat: 2`, `dog: 1`

**Edge cases**
1) Empty input then `exit`
   - Expected: no words; unique `0`, total `0`
2) Only punctuation: `!!! ,,, ---` then `exit`
   - Expected: no words
3) Mixed unicode words: `São são SÃO` then `exit`
   - Expected: `são: 3` (works due to `\p{L}`)


