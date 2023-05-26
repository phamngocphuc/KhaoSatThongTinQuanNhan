/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author DELL
 */
public class CenteredHeaderRenderer extends DefaultTableCellRenderer{
    
    private final Border headerBorder = new LineBorder(Color.BLACK, 1);
    
    public CenteredHeaderRenderer() {
        setHorizontalAlignment(SwingConstants.CENTER); // Thiết lập giá trị căn giữa cho renderer
        setBorder(headerBorder);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setFont(getFont().deriveFont(Font.BOLD)); // Thiết lập font in đậm cho tiêu đề
        setBackground(table.getTableHeader().getBackground()); // Thiết lập màu nền cho tiêu đề
        return this;
    }
}
