package md.tekwill.dao.helper.validator;

public class Validator {

    public static boolean validateInsert(int usedSpace, int maxSpace) throws Exception {

        if(usedSpace < maxSpace) {
            return true;
        } else {
            throw new Exception("No free space to add new record !");
        }
    }

    protected static boolean validateID(int ID, String message) throws Exception {

        if(ID >= 0) {
            return true;
        } else {
            throw new Exception(message);
        }
    }

    protected static boolean checkNull(Object object, String message) throws Exception {

        if(object == null) {
            throw new Exception(message);
        }

        return true;
    }

    protected static boolean checkNull(String string, String message) throws Exception {

        if(string == null) {
            throw new Exception(message);
        }

        return true;
    }

    protected static boolean checkEmpty(String string, String message) throws Exception {

        if(string.trim().isEmpty()) {
            throw new Exception(message);
        }

        return true;
    }

    protected static boolean checkSize(String string, String message) throws Exception {

        if(string.length() < 2 || string.length() > 20) {
            throw new Exception(message);
        }

        return true;
    }

    protected static boolean checkName(String string, String message) throws Exception {

        if(!string.chars().allMatch(c -> Character.isLetterOrDigit(c) || Character.isWhitespace(c))) {
            throw new Exception(message);
        }

        return true;
    }

    protected static boolean validateString(String string, String errorHead) throws Exception {

        return checkNull(string, errorHead + " name cannot be null !")
                && checkEmpty(string, errorHead + " name cannot be blank !")
                && checkSize(string, errorHead + " name must be at least 2 letters long and cannot exceed 20 characters !")
                && checkName(string, errorHead + " must contain only letters, digits or space !");
    }
}
