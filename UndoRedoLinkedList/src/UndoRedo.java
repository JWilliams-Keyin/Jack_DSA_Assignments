import java.util.LinkedList;
import java.util.Scanner;

public class UndoRedo<T> {

    // Attributes

    LinkedList<T> inputStates = new LinkedList<>();
    int currentIndex = -1;

    // Methods

    public void addNewState(T newState) {
        // If state has been undone and overwritten, remove redo state
        if (inputStates.size() > currentIndex + 1) {
            inputStates.removeLast();
        }

        inputStates.add(newState);
        currentIndex++;
    }

    public void undo() {
        // If the currentIndex is bigger than 0, then that means there is a state to undo to
        if (currentIndex > 0) {
            currentIndex--;
        } else {
            System.out.println("There is nothing available to undo!");
        }
    }

    public void redo() {
        // If the currentIndex is less than the size - 1, then there is a state to redo to
        if (currentIndex < inputStates.size() - 1) {
            currentIndex++;
        } else {
            System.out.println("There is nothing available to redo!");
        }
    }

    public T getCurrentState() {
        // If the currentIndex >= 0 and is smaller than the size of the list, then the function gets the state
        if (currentIndex >= 0 && currentIndex < inputStates.size()) {
            return inputStates.get(currentIndex);

        // If the above conditions aren't met, that means there is no state, so the function returns null
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UndoRedo<Object> undoRedoManager = new UndoRedo<>();

        System.out.println("Commands: --undo, --redo, --quit");
        System.out.println("Anything else will be entered as a state");

        while (true) {
            Object command = scanner.next();

            if (command.equals("--quit")){
                break;
            } else if (command.equals("--undo")) {
                undoRedoManager.undo();
                System.out.println("Current state: " + undoRedoManager.getCurrentState());
            } else if (command.equals("--redo")) {
                undoRedoManager.redo();
                System.out.println("Current state: " + undoRedoManager.getCurrentState());
            } else {
                undoRedoManager.addNewState(command);
            }
        }
    }
}
