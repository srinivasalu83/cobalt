package compiler.block.ifs;

import compiler.Parameter;
import compiler.Utils;
import compiler.block.Block;
import compiler.symbol_table.SymbolTable;

public class IfBlock extends Block {

    private String type = "if";
    private Parameter[] params;
    String name;
    String pointer;
    String operator;
    String value;

    String byteCodeOp;

    public IfBlock(Block superBlock, String name) {
        super(superBlock, true, false);
        this.name = name;

        String[] split = name.split(" ");

        //  x == 10
        if(split.length > 1) {
            pointer = split[0];
            pointer = ""+ SymbolTable.getInstance().getValue(Utils.getMethod(this), split[0]).getId();
            operator = split[1];
            value = split[2];


            if(operator.equals("==")){
                byteCodeOp =  "mv.visitJumpInsn(IF_ICMPGE, l"+id+");\n";
            }else if(operator.equals("<")){
                byteCodeOp =  "mv.visitJumpInsn(IF_ICMPGE, l"+id+");\n";
            }else if(operator.equals(">")){
                byteCodeOp =  "mv.visitJumpInsn(IF_ICMPGE, l"+id+");\n";
            }else if(operator.equals("<=")){
                byteCodeOp =  "mv.visitJumpInsn(IF_ICMPGE, l"+id+");\n";
            }else if(operator.equals(">=")){
                byteCodeOp =  "mv.visitJumpInsn(IF_ICMPGE, l"+id+");\n";
            }else{
                System.out.println("Error: Disallowed Operator" + this.getClass());
            }

        }else{
            //boolean value
            value = name;

        }

    }

    public String getName() {
        return name;
    }

    @Override
    public String getValue() {
        return null;
    }

    public String getType() {
        return type;
    }

    @Override
    public String getOpeningCode() {
        return  "mv.visitVarInsn(ILOAD,"+pointer+");" +
                "mv.visitLdcInsn("+value+");\n" +
                "Label l"+id+" = new Label();\n" +
                byteCodeOp;
    }

    @Override
    public String getBodyCode() {
        return "";
    }

    @Override
    public String getClosingCode() {
        return "mv.visitLabel(l"+id+");"
               ;
    }



    public Parameter[] getParameters() {
        return params;
    }


    @Override
    public void init() {

    }

    @Override
    public void run() {

    }
}