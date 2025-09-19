class Spreadsheet {
    private Map<String, Integer> map;

    public Spreadsheet(int rows) {
        map = new HashMap<>();
    }

    public void setCell(String cell, int value) {
        map.put(cell, value);
    }

    public void resetCell(String cell) {
        map.remove(cell);
    }

    public int getValue(String formula) {
        String s = formula.substring(1);
        String[] parts = s.split("\\+");
        return getOperand(parts[0]) + getOperand(parts[1]);
    }

    private int getOperand(String op) {
        if (Character.isDigit(op.charAt(0))) {
            return Integer.parseInt(op);
        }
        return map.getOrDefault(op, 0);
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */