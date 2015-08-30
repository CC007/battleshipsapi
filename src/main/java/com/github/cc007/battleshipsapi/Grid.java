/* 
 * The MIT License
 *
 * Copyright 2015 Rik Schaaf aka CC007 (http://coolcat007.nl/).
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.github.cc007.battleshipsapi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rik Schaaf aka CC007 (http://coolcat007.nl/)
 */
public class Grid implements Serializable{
    private final List<GridColumn> gridColumns;

    public Grid() {
        this.gridColumns = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            this.gridColumns.add(new GridColumn());
        }
    }
    
    public GridColumn get(char columnLetter){
        return gridColumns.get(Character.toUpperCase(columnLetter)-65);
    }
    
    public List<List<Field>> getGridFields(){
        List<List<Field>> gridFields = new ArrayList<>();
        for (GridColumn gridColumn : gridColumns) {
            gridFields.add(gridColumn.getColumnFields());
        }
        return gridFields;
    }
    
    public void setGridFields(List<List<Field>> gridFields){
        for (int i = 0; i < gridFields.size(); i++) {
            this.gridColumns.get(i).setColumnFields(gridFields.get(i));
        }
    }
    
}
