package com.epam.rd.autotasks.words;

import java.util.Arrays;

public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        if (words == null || sample == null) {
            return 0;
        }
        String newSample = sample.replaceAll("[\t]+|[\n]+", "");
        int equalWordsNumber = 0;
        for (String word : words) {
            if (word.trim().equalsIgnoreCase(newSample)) equalWordsNumber++;
        }
        return equalWordsNumber;
    }

    public static String[] splitWords(String text) {
        if (text == null || text.isEmpty()) return null;
        if (text.matches("[.,!?:; ]+")) return null;
        String newText = text.replaceAll("[.,!?:; ]+", " ").trim();
        String[] wordsSplittedFromTextArray = newText.split("\\s+");

        if (wordsSplittedFromTextArray == null || wordsSplittedFromTextArray.length == 0) {
            return null;
        }
        return wordsSplittedFromTextArray;
    }

    public static String convertPath(String path, boolean toWin) {
        if (path == null || path.length() == 0) return null;
        if ((path.contains("/") && path.contains("\\"))
                || path.contains("//") || path.contains("~~")
                || path.contains("\\C:") || path.startsWith("C:/")
                || path.contains("/~") || path.contains("~\\")) {
            return null;
        }
        if (toWin) {
            StringBuilder windowsPath = new StringBuilder("");

            if (path.contentEquals("~")) {
                windowsPath.append("C:\\User");
                return windowsPath.toString();
            } else if (path.contentEquals("~/")) {
                windowsPath.append("C:\\User\\");
                return windowsPath.toString();
            } else if (path.contentEquals("/")) {
                windowsPath.append("C:\\");
                return windowsPath.toString();
            } else if (path.contentEquals("..")) {
                windowsPath.append("..");
                return windowsPath.toString();
            } else if (path.contentEquals(".")) {
                windowsPath.append(".");
                return windowsPath.toString();
            }

            if (path.startsWith("~/")) {
                windowsPath.append("C:\\User\\");
            } else if (path.charAt(0) == '/') {
                windowsPath.append("C:\\");
            }

            String newText = path.replaceAll("[~/]+", "!!").trim();
            String[] pathFolderNames = newText.split("!!");
            int emptyFolderNamesCount = 0;
            for (int i = 0; i < pathFolderNames.length; i++) {
                if (pathFolderNames[i].isEmpty()) {
                    emptyFolderNamesCount++;
                    continue;
                }
                windowsPath.append(pathFolderNames[i] + "\\");
            }
            if (emptyFolderNamesCount == pathFolderNames.length) return null;
            if (windowsPath == null || windowsPath.toString().isEmpty()) return  null;

            windowsPath.deleteCharAt(windowsPath.length()-1);
            if (path.endsWith("/")) {
                windowsPath.append("\\");
                return windowsPath.toString();
            }
            return windowsPath.toString();
        }

        if (!toWin) {
            StringBuilder unixPath = new StringBuilder("");
            if (path.contentEquals("C:\\User")) {
                unixPath.append("~");
                return unixPath.toString();
            } else if (path.contentEquals("C:\\User\\")) {
                unixPath.append("~/");
                return unixPath.toString();
            } else if (path.contentEquals("C:\\")) {
                unixPath.append("/");
                return unixPath.toString();
            } else if (path.contentEquals("..")) {
                unixPath.append("..");
                return unixPath.toString();
            } else if (path.contentEquals(".")) {
                unixPath.append(".");
                return unixPath.toString();
            }
            if (path.startsWith("C:\\User\\")) {
                unixPath.append("~/");
            } else if (path.startsWith("C:\\")) {
                unixPath.append("/");
            } else if (path.startsWith("\\")) {
                unixPath.append("/");
            }
            String newText = path.replaceAll("\\\\+","!!").trim();
            newText = newText.replaceAll("[a-zA-Z]{1}[:]{1}", "!!");
            newText = newText.replace("User", "!!").trim();
            String[] pathFoldersNames = newText.split("!!");
            int emptyFolderNamesCount = 0;
            for (int i = 0; i < pathFoldersNames.length; i++) {
                if (pathFoldersNames[i].isEmpty()) {
                    emptyFolderNamesCount++;
                    continue;
                }
                unixPath.append(pathFoldersNames[i] + "/");
            }
            if (emptyFolderNamesCount == pathFoldersNames.length) return null;
            if (unixPath == null || unixPath.toString().isEmpty()) return  null;

            unixPath.deleteCharAt(unixPath.length()-1);
            if (path.endsWith("\\")) {
                unixPath.append("/");
                return unixPath.toString();
            }
            return unixPath.toString();
        }
        return null;
    }

    public static String joinWords(String[] words) {
        if (words == null || words.length == 0) return null;
        int emptyWordsCount = 0;
        StringBuilder joinedWords = new StringBuilder("[");
        for (int i = 0; i < words.length; i++) {
            if (words[i].isEmpty()) {
                emptyWordsCount++;
                continue;
            }
            joinedWords.append(words[i] + ", ");
        }
        if (emptyWordsCount == words.length) return null;
        joinedWords.delete(joinedWords.length()-2, joinedWords.length());
        joinedWords.append(']');
        if (joinedWords == null || joinedWords.toString().isEmpty()) return  null;
        return joinedWords.toString();
    }

    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS", };
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}