/*Copyright (c) 2016-2017 testing1.com All Rights Reserved.
 This software is the confidential and proprietary information of testing1.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing1.com*/

package com.test_21.qadatabase;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;



/**
 * Reps generated by hbm2java
 */
@Entity
@Table(name="`reps`"
)

public class Reps  implements java.io.Serializable {

    
    private Integer id;
    
    private Integer channelType;
    
    private String name;

    public Reps() {
    }


    @Id @GeneratedValue(strategy=IDENTITY)
    

    @Column(name="`id`", precision=10)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    

    @Column(name="`channel_type`", precision=10)
    public Integer getChannelType() {
        return this.channelType;
    }
    
    public void setChannelType(Integer channelType) {
        this.channelType = channelType;
    }

    

    @Column(name="`name`", length=32)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof Reps) )
		    return false;

		 Reps that = (Reps) o;

		 return ( (this.getId()==that.getId()) || ( this.getId()!=null && that.getId()!=null && this.getId().equals(that.getId()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );

         return result;
    }


}

