import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1350641181
   )
   public int field3445;
   @ObfuscatedName("w")
   static IndexDataBase field3446;
   @ObfuscatedName("a")
   static IndexDataBase field3447;
   @ObfuscatedName("h")
   @Export("clipped")
   public boolean clipped;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1775505633
   )
   @Export("sizeY")
   public int sizeY;
   @ObfuscatedName("r")
   static NodeCache field3450;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1152342737
   )
   public int field3451;
   @ObfuscatedName("y")
   static ModelData[] field3452;
   @ObfuscatedName("k")
   @Export("objectModels")
   int[] objectModels;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 281531655
   )
   @Export("mapIconId")
   public int mapIconId;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1651482075
   )
   @Export("contrast")
   int contrast;
   @ObfuscatedName("u")
   public boolean field3456;
   @ObfuscatedName("z")
   @Export("recolorToFind")
   short[] recolorToFind;
   @ObfuscatedName("l")
   @Export("recolorToReplace")
   short[] recolorToReplace;
   @ObfuscatedName("c")
   @Export("textureToFind")
   short[] textureToFind;
   @ObfuscatedName("m")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -119346485
   )
   @Export("sizeX")
   public int sizeX;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -618488903
   )
   public int field3462;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 305444299
   )
   public int field3463;
   @ObfuscatedName("i")
   static boolean field3464;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -101739821
   )
   @Export("varpId")
   int varpId;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1279199637
   )
   int field3466;
   @ObfuscatedName("d")
   @Export("nonFlatShading")
   boolean nonFlatShading;
   @ObfuscatedName("e")
   @Export("objectTypes")
   int[] objectTypes;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 90532835
   )
   @Export("animationId")
   public int animationId;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -361428575
   )
   @Export("ambient")
   int ambient;
   @ObfuscatedName("t")
   static NodeCache field3471;
   @ObfuscatedName("aa")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("aw")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("ac")
   public boolean field3474;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 736143915
   )
   @Export("mapSceneId")
   public int mapSceneId;
   @ObfuscatedName("au")
   @Export("isRotated")
   boolean isRotated;
   @ObfuscatedName("ar")
   public boolean field3477;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -2116533733
   )
   @Export("modelSizeX")
   int modelSizeX;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1470404543
   )
   @Export("modelSizeHeight")
   int modelSizeHeight;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -752025305
   )
   @Export("modelSizeY")
   int modelSizeY;
   @ObfuscatedName("o")
   @Export("name")
   public String name;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 2144378703
   )
   @Export("offsetHeight")
   int offsetHeight;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1418818125
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1123438753
   )
   @Export("configId")
   int configId;
   @ObfuscatedName("at")
   @Export("isSolid")
   boolean isSolid;
   @ObfuscatedName("v")
   static NodeCache field3486;
   @ObfuscatedName("s")
   public static NodeCache field3487;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -714251031
   )
   public int field3488;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 664689767
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -130217133
   )
   @Export("ambientSoundId")
   public int ambientSoundId;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 839454771
   )
   public int field3491;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 863407893
   )
   public int field3492;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 215005745
   )
   public int field3493;
   @ObfuscatedName("ap")
   public int[] field3494;
   @ObfuscatedName("af")
   class186 field3495;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1850947186"
   )
   void method4512() {
      if(this.field3488 == -1) {
         this.field3488 = 0;
         if(this.objectModels != null && (this.objectTypes == null || this.objectTypes[0] == 10)) {
            this.field3488 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.actions[var1] != null) {
               this.field3488 = 1;
            }
         }
      }

      if(this.field3451 == -1) {
         this.field3451 = this.field3463 != 0?1:0;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)LRenderable;",
      garbageValue = "-1378839515"
   )
   public final Renderable method4513(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)((this.field3445 << 10) + var2);
      } else {
         var7 = (long)((var1 << 3) + (this.field3445 << 10) + var2);
      }

      Object var9 = (Renderable)field3450.get(var7);
      if(var9 == null) {
         ModelData var10 = this.method4520(var1, var2);
         if(var10 == null) {
            return null;
         }

         if(!this.nonFlatShading) {
            var9 = var10.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         } else {
            var10.field1801 = (short)(this.ambient + 64);
            var10.field1836 = (short)(this.contrast + 768);
            var10.computeNormals();
            var9 = var10;
         }

         field3450.put((CacheableNode)var9, var7);
      }

      if(this.nonFlatShading) {
         var9 = ((ModelData)var9).method2415();
      }

      if(this.field3466 >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2539(var3, var4, var5, var6, true, this.field3466);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2467(var3, var4, var5, var6, true, this.field3466);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-20"
   )
   public final boolean method4515(int var1) {
      if(this.objectTypes != null) {
         for(int var4 = 0; var4 < this.objectTypes.length; ++var4) {
            if(this.objectTypes[var4] == var1) {
               return field3447.method4116(this.objectModels[var4] & '\uffff', 0);
            }
         }

         return true;
      } else if(this.objectModels == null) {
         return true;
      } else if(var1 != 10) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.objectModels.length; ++var3) {
            var2 &= field3447.method4116(this.objectModels[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2025827132"
   )
   public final boolean method4516() {
      if(this.objectModels == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.objectModels.length; ++var2) {
            var1 &= field3447.method4116(this.objectModels[var2] & '\uffff', 0);
         }

         return var1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)LModel;",
      garbageValue = "500536804"
   )
   public final Model method4518(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.objectTypes == null) {
         var7 = (long)((this.field3445 << 10) + var2);
      } else {
         var7 = (long)((var1 << 3) + (this.field3445 << 10) + var2);
      }

      Model var9 = (Model)field3486.get(var7);
      if(var9 == null) {
         ModelData var10 = this.method4520(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3486.put(var9, var7);
      }

      if(this.field3466 >= 0) {
         var9 = var9.method2539(var3, var4, var5, var6, true, this.field3466);
      }

      return var9;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II[[IIIILSequence;II)LModel;",
      garbageValue = "1208965827"
   )
   public final Model method4519(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.objectTypes == null) {
         var9 = (long)((this.field3445 << 10) + var2);
      } else {
         var9 = (long)((var1 << 3) + (this.field3445 << 10) + var2);
      }

      Model var11 = (Model)field3486.get(var9);
      if(var11 == null) {
         ModelData var12 = this.method4520(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         field3486.put(var11, var9);
      }

      if(var7 == null && this.field3466 == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method4709(var11, var8, var2);
         } else {
            var11 = var11.method2530(true);
         }

         if(this.field3466 >= 0) {
            var11 = var11.method2539(var3, var4, var5, var6, false, this.field3466);
         }

         return var11;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)LModelData;",
      garbageValue = "2110067453"
   )
   final ModelData method4520(int var1, int var2) {
      ModelData var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(this.objectTypes == null) {
         if(var1 != 10) {
            return null;
         }

         if(this.objectModels == null) {
            return null;
         }

         var4 = this.isRotated;
         if(var1 == 2 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.objectModels.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            var7 = this.objectModels[var6];
            if(var4) {
               var7 += 65536;
            }

            var3 = (ModelData)field3487.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method2414(field3447, var7 & '\uffff', 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2424();
               }

               field3487.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field3452[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field3452, var5);
         }
      } else {
         int var9 = -1;

         for(var5 = 0; var5 < this.objectTypes.length; ++var5) {
            if(this.objectTypes[var5] == var1) {
               var9 = var5;
               break;
            }
         }

         if(var9 == -1) {
            return null;
         }

         var5 = this.objectModels[var9];
         boolean var10 = this.isRotated ^ var2 > 3;
         if(var10) {
            var5 += 65536;
         }

         var3 = (ModelData)field3487.get((long)var5);
         if(var3 == null) {
            var3 = ModelData.method2414(field3447, var5 & '\uffff', 0);
            if(var3 == null) {
               return null;
            }

            if(var10) {
               var3.method2424();
            }

            field3487.put(var3, (long)var5);
         }
      }

      if(this.modelSizeX == 128 && this.modelSizeHeight == 128 && this.modelSizeY == 128) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var11;
      if(this.offsetX == 0 && this.offsetHeight == 0 && this.offsetY == 0) {
         var11 = false;
      } else {
         var11 = true;
      }

      ModelData var8 = new ModelData(var3, var2 == 0 && !var4 && !var11, null == this.recolorToFind, null == this.textureToFind, true);
      if(var1 == 4 && var2 > 3) {
         var8.method2421(256);
         var8.method2430(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method2418();
      } else if(var2 == 2) {
         var8.method2419();
      } else if(var2 == 3) {
         var8.method2420();
      }

      if(this.recolorToFind != null) {
         for(var7 = 0; var7 < this.recolorToFind.length; ++var7) {
            var8.method2422(this.recolorToFind[var7], this.recolorToReplace[var7]);
         }
      }

      if(this.textureToFind != null) {
         for(var7 = 0; var7 < this.textureToFind.length; ++var7) {
            var8.method2450(this.textureToFind[var7], this.textureToReplace[var7]);
         }
      }

      if(var4) {
         var8.method2425(this.modelSizeX, this.modelSizeHeight, this.modelSizeY);
      }

      if(var11) {
         var8.method2430(this.offsetX, this.offsetHeight, this.offsetY);
      }

      return var8;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1145962525"
   )
   public boolean method4524() {
      if(this.impostorIds == null) {
         return this.ambientSoundId != -1 || this.field3494 != null;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = class251.getObjectDefinition(this.impostorIds[var1]);
               if(var2.ambientSoundId != -1 || var2.field3494 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)Ljava/lang/String;",
      garbageValue = "-29"
   )
   public String method4525(int var1, String var2) {
      return class92.method1733(this.field3495, var1, var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-628774378"
   )
   void method4547(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.loadData(var1, var2);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "763721957"
   )
   public int method4548(int var1, int var2) {
      return ChatLineBuffer.method1884(this.field3495, var1, var2);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LBuffer;IS)V",
      garbageValue = "-12998"
   )
   @Export("loadData")
   void loadData(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(this.objectModels != null && !field3464) {
               var1.offset += var3 * 3;
            } else {
               this.objectTypes = new int[var3];
               this.objectModels = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.objectModels[var4] = var1.readUnsignedShort();
                  this.objectTypes[var4] = var1.readUnsignedByte();
               }
            }
         }
      } else if(var2 == 2) {
         this.name = var1.readString();
      } else if(var2 == 5) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(this.objectModels != null && !field3464) {
               var1.offset += var3 * 2;
            } else {
               this.objectTypes = null;
               this.objectModels = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.objectModels[var4] = var1.readUnsignedShort();
               }
            }
         }
      } else if(var2 == 14) {
         this.sizeX = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.sizeY = var1.readUnsignedByte();
      } else if(var2 == 17) {
         this.field3463 = 0;
         this.field3456 = false;
      } else if(var2 == 18) {
         this.field3456 = false;
      } else if(var2 == 19) {
         this.field3488 = var1.readUnsignedByte();
      } else if(var2 == 21) {
         this.field3466 = 0;
      } else if(var2 == 22) {
         this.nonFlatShading = true;
      } else if(var2 == 23) {
         this.clipped = true;
      } else if(var2 == 24) {
         this.animationId = var1.readUnsignedShort();
         if(this.animationId == '\uffff') {
            this.animationId = -1;
         }
      } else if(var2 == 27) {
         this.field3463 = 1;
      } else if(var2 == 28) {
         this.field3462 = var1.readUnsignedByte();
      } else if(var2 == 29) {
         this.ambient = var1.readByte();
      } else if(var2 == 39) {
         this.contrast = var1.readByte() * 25;
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.readString();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.recolorToFind = new short[var3];
         this.recolorToReplace = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.recolorToFind[var4] = (short)var1.readUnsignedShort();
            this.recolorToReplace[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.textureToFind = new short[var3];
         this.textureToReplace = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.textureToFind[var4] = (short)var1.readUnsignedShort();
            this.textureToReplace[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 62) {
         this.isRotated = true;
      } else if(var2 == 64) {
         this.field3477 = false;
      } else if(var2 == 65) {
         this.modelSizeX = var1.readUnsignedShort();
      } else if(var2 == 66) {
         this.modelSizeHeight = var1.readUnsignedShort();
      } else if(var2 == 67) {
         this.modelSizeY = var1.readUnsignedShort();
      } else if(var2 == 68) {
         this.mapSceneId = var1.readUnsignedShort();
      } else if(var2 == 69) {
         var1.readUnsignedByte();
      } else if(var2 == 70) {
         this.offsetX = var1.readShort();
      } else if(var2 == 71) {
         this.offsetHeight = var1.readShort();
      } else if(var2 == 72) {
         this.offsetY = var1.readShort();
      } else if(var2 == 73) {
         this.field3474 = true;
      } else if(var2 == 74) {
         this.isSolid = true;
      } else if(var2 == 75) {
         this.field3451 = var1.readUnsignedByte();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.ambientSoundId = var1.readUnsignedShort();
            this.field3491 = var1.readUnsignedByte();
         } else if(var2 == 79) {
            this.field3492 = var1.readUnsignedShort();
            this.field3493 = var1.readUnsignedShort();
            this.field3491 = var1.readUnsignedByte();
            var3 = var1.readUnsignedByte();
            this.field3494 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3494[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.field3466 = var1.readUnsignedByte() * 256;
         } else if(var2 == 82) {
            this.mapIconId = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.field3495 = XClanMember.method1181(var1, this.field3495);
         }
      } else {
         this.varpId = var1.readUnsignedShort();
         if(this.varpId == '\uffff') {
            this.varpId = -1;
         }

         this.configId = var1.readUnsignedShort();
         if(this.configId == '\uffff') {
            this.configId = -1;
         }

         var3 = -1;
         if(var2 == 92) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         var4 = var1.readUnsignedByte();
         this.impostorIds = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.impostorIds[var5] = var1.readUnsignedShort();
            if(this.impostorIds[var5] == '\uffff') {
               this.impostorIds[var5] = -1;
            }
         }

         this.impostorIds[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)LObjectComposition;",
      garbageValue = "2072415874"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.varpId != -1) {
         var1 = WorldMapType1.method264(this.varpId);
      } else if(this.configId != -1) {
         var1 = class211.widgetSettings[this.configId];
      }

      int var2;
      if(var1 >= 0 && var1 < this.impostorIds.length - 1) {
         var2 = this.impostorIds[var1];
      } else {
         var2 = this.impostorIds[this.impostorIds.length - 1];
      }

      return var2 != -1?class251.getObjectDefinition(var2):null;
   }

   ObjectComposition() {
      this.name = "null";
      this.sizeX = 1;
      this.sizeY = 1;
      this.field3463 = 2;
      this.field3456 = true;
      this.field3488 = -1;
      this.field3466 = -1;
      this.nonFlatShading = false;
      this.clipped = false;
      this.animationId = -1;
      this.field3462 = 16;
      this.ambient = 0;
      this.contrast = 0;
      this.actions = new String[5];
      this.mapIconId = -1;
      this.mapSceneId = -1;
      this.isRotated = false;
      this.field3477 = true;
      this.modelSizeX = 128;
      this.modelSizeHeight = 128;
      this.modelSizeY = 128;
      this.offsetX = 0;
      this.offsetHeight = 0;
      this.offsetY = 0;
      this.field3474 = false;
      this.isSolid = false;
      this.field3451 = -1;
      this.varpId = -1;
      this.configId = -1;
      this.ambientSoundId = -1;
      this.field3491 = 0;
      this.field3492 = 0;
      this.field3493 = 0;
   }

   static {
      field3464 = false;
      field3471 = new NodeCache(4096);
      field3487 = new NodeCache(500);
      field3450 = new NodeCache(30);
      field3486 = new NodeCache(30);
      field3452 = new ModelData[4];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILclass219;I)LScript;",
      garbageValue = "205688062"
   )
   static Script method4573(int var0, class219 var1) {
      Script var2 = (Script)Script.field1551.get((long)(var0 << 16));
      if(var2 != null) {
         return var2;
      } else {
         String var3 = String.valueOf(var0);
         int var4 = class169.indexScripts.method4146(var3);
         if(var4 == -1) {
            return null;
         } else {
            byte[] var5 = class169.indexScripts.method4120(var4);
            if(var5 != null) {
               if(var5.length <= 1) {
                  return null;
               }

               var2 = class48.method738(var5);
               if(var2 != null) {
                  Script.field1551.put(var2, (long)(var0 << 16));
                  return var2;
               }
            }

            return null;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;IIB)LSpritePixels;",
      garbageValue = "1"
   )
   public static SpritePixels method4574(IndexDataBase var0, int var1, int var2) {
      if(!class223.method4073(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels var4 = new SpritePixels();
         var4.maxWidth = class286.field3801;
         var4.maxHeight = class286.field3796;
         var4.offsetX = class286.field3799[0];
         var4.offsetY = class286.field3800[0];
         var4.width = class7.field239[0];
         var4.height = class226.field3146[0];
         int var5 = var4.height * var4.width;
         byte[] var6 = class210.field2609[0];
         var4.image = new int[var5];

         for(int var7 = 0; var7 < var5; ++var7) {
            var4.image[var7] = class278.field3745[var6[var7] & 255];
         }

         XGrandExchangeOffer.method113();
         return var4;
      }
   }
}
