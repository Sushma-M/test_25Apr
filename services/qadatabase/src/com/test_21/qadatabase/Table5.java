/*Copyright (c) 2016-2017 testing1.com All Rights Reserved.
 This software is the confidential and proprietary information of testing1.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing1.com*/

package com.test_21.qadatabase;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;



/**
 * Table5 generated by hbm2java
 */
@Entity
@Table(name="`TABLE5`"
)

public class Table5  implements java.io.Serializable {

    
    private Integer id;
    
    private Table6 table6;

    public Table5() {
    }


    @Id @GeneratedValue(strategy=IDENTITY)
    

    @Column(name="`ID`", precision=10)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`COLUMN2`")
    public Table6 getTable6() {
        return this.table6;
    }
    
    public void setTable6(Table6 table6) {
        this.table6 = table6;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof Table5) )
		    return false;

		 Table5 that = (Table5) o;

		 return ( (this.getId()==that.getId()) || ( this.getId()!=null && that.getId()!=null && this.getId().equals(that.getId()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );

         return result;
    }


}

