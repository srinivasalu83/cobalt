package compiler.block.operators;

import compiler.Utils;
import compiler.block.Block;
import compiler.symbol_table.SymbolTable;

public class AddBlock extends Block {

    private String type = "add";
    private String value;
    private String name;

    public AddBlock(Block superBlock, String name, String value) {
        super(superBlock, false, false);
        this.name = name;
        this.value = value;
        setId(SymbolTable.getInstance().getValue(Utils.getMethod(this), name).getId());
    }

    @Override
    public void init() {

    }

    @Override
    public void run() {

    }

    public String getType() {
        return type;
    }

    @Override
    public String getOpeningCode() {
        return "";
    }

    @Override
    public String getClosingCode() {
        return "";
    }

    @Override
    public String getBodyCode() {
        return "mv.visitLdcInsn("+value+");\n"+
                "mv.visitVarInsn(ILOAD,"+getId()+");\n" +
                "mv.visitInsn(IADD);\n" +
                "mv.visitVarInsn(ISTORE,"+getId()+");\n";
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}