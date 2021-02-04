package lab02a.src;
import java.util.*;
import tester.Tester;

public class FileTester {
    File testFile = new File();
    Item radio = new Item("radio", true);
    Item hat = new Item("green witch hat", false);

    public void initFile() {
        testFile = new File();
        testFile.addItem(radio);
        testFile.addItem(hat);
    }
    public void testRemoveItem(Tester t) {
        initFile();
        testFile.removeItem(radio);
        LinkedList<Item> expected = new LinkedList<Item>();
        t.checkExpect(testFile.findClues("hat"), expected.add(hat));
    }
    public void testLookupSolved(Tester t) {
        initFile();
        t.checkExpect(testFile.lookupSolved(radio.description), true);
    }
    public void testCountClues(Tester t) {
        initFile();
        t.checkExpect(testFile.countClues("a"), 2);
        t.checkExpect(testFile.countClues("radio"), 1);
        t.checkExpect(testFile.countClues("green witch"), 1);
    }
    public void testFindClues(Tester t) {
        initFile();
        LinkedList<Item> expected = new LinkedList<Item>();
        expected.add(radio);
        t.checkExpect(testFile.findClues("radi"), expected);
        expected.add(hat);
        t.checkExpect(testFile.findClues("r"), expected);
    }
    public static void main(String[] args) {
        Tester.run(new FileTester());
    }
}
