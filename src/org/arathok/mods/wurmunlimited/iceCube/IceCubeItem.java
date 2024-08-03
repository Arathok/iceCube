package org.arathok.mods.wurmunlimited.iceCube;

import com.wurmonline.server.items.*;
import com.wurmonline.server.skills.SkillList;
import com.wurmonline.shared.constants.IconConstants;
import com.wurmonline.shared.util.MaterialUtilities;
import org.gotti.wurmunlimited.modsupport.ItemTemplateBuilder;

import java.io.IOException;

public class IceCubeItem {

    public static ItemTemplate iceCube;

    public static int iceCubeId;
    //TODO: add functionality that a larder can cool water to an icecube OR make cooler machine needs snowballs and water
    public static void registerIceCube() throws IOException {

        iceCube= new ItemTemplateBuilder("arathok.iceCube.iceCube")  // Vanilla ItemTemplateCreator copied from a rope
                .name("ice Cube","ice Cubes","A cold object that can soothe burnt parts of your body.")
                .descriptions("excellent","still cold","melting","cold puddle")
                .itemTypes( new short[]{
                        ItemTypes.ITEM_TYPE_NAMED,
                        ItemTypes.ITEM_TYPE_TURNABLE,
                        ItemTypes.ITEM_TYPE_DECORATION,


                })
                .imageNumber((short) IconConstants.ICON_ARTIFACT_VALREI) // icon in the inventory
                .behaviourType((short) 1)
                .combatDamage(1)
                .decayTime((3600*1000)) // decaytime in milliseconds (seconds*1000) item will get a damage tick after this time
                .dimensions(5,5,5) // Volume of the Item which it will fill up inside a container
                .modelName("model.iceCube.iceCube.")
                .difficulty(1.0F) // crafting chance and also skill tick more difficult means more skill
                .weightGrams(125)
                .material(MaterialUtilities.MATERIAL_WATER)
                .value(10) //worth in iron coins
                .isTraded(true)
                .build();

            iceCubeId=iceCube.getTemplateId();

            CreationEntryCreator.createSimpleEntry(SkillList.COOKING_BEVERAGES,ItemList.snowball,ItemList.snowball,iceCubeId,
                    true,true,0.0F,true,false,0,5.0D, CreationCategories.HEALING);



    }

}
