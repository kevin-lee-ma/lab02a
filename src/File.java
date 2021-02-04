package lab02a.src;
import java.util.*;

public class File {
    public List<Item> clues;
    public File() {
        clues = new LinkedList<Item>();
    }
    public void addItem(Item toAdd) {
        clues.add(toAdd);
    }
    public void removeItem(Item toRemove) {
        clues.remove(toRemove);
    }

//    public boolean lookupSolved(String desc) {
//        for (int i = 0; i < clues.size(); i++) {
//            Item curr = clues.get(i);
//            if (curr.description.equals(desc)) {
//                return curr.solved;
//            }
//        }
//        throw new RuntimeException();
//    }

    /**
     * Given a clue description, returns whether or not that case is solved
     * @param desc - String, description of the query case
     * @return whether or not the query case is solved
     */
    public boolean lookupSolved(String desc) {
        for (Item curr : clues) {
            if (curr.description.equals(desc)) {
                return curr.solved;
            }
        }
        throw new RuntimeException();
    }

//    public int countClues(String desc) {
//        int total = 0;
//        for (int i = 0; i < clues.size(); i++) {
//            Item curr = clues.get(i);
//            if (curr.description.contains(desc)) {
//                total++;
//            }
//        }
//        return total;
//    }
    /**
     * Given a clue description, return the number of clues in the file that contain it
     * @param desc - String that may be contained in clues' descriptions
     * @return the number of clues in the file that contain desc in their description
     */
    public int countClues(String desc) {
        int total = 0;
        for (Item curr : clues) {
            if (curr.description.contains(desc)) {
                total++;
            }
        }
        return total;
    }

    /**
     * Given a clue description, return a List of clues in the file that contain it
     * @param desc - String that may be contained in clues' descriptions
     * @return the List of Items whose descriptions contain desc
     */
    public List<Item> findClues(String desc) {
        List<Item> itemList = new LinkedList<Item>();
        for (Item curr : clues) {
            if (curr.description.contains(desc)) {
                itemList.add(curr);
            }
        }
        return itemList;
    }

    /**
     * Given a clue description and a boolean, update the File so that all clues
     * with that description have the correct value for whether they have been
     * solved. If the clue isn't found, throws a RuntimeException.
     * @param desc - String description to look for
     * @param newSolved - Boolean value to set the items' solved field to
     */
    public void updateSolved(String desc, boolean newSolved) {
        boolean found = false;
        for (Item curr : clues) {
            if (curr.description.equals(desc)) {
                curr.solved = newSolved;
                found = true;
            }
        }
        if (!found) {
            throw new RuntimeException();
        }
    }
}
