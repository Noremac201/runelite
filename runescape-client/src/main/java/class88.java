import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cm")
@Implements("Frame")
public class class88 {
   @ObfuscatedName("l")
   int[] field1547;
   @ObfuscatedName("i")
   static int[] field1548 = new int[500];
   @ObfuscatedName("g")
   static int[] field1549 = new int[500];
   @ObfuscatedName("h")
   static int[] field1550 = new int[500];
   @ObfuscatedName("t")
   static int[] field1551 = new int[500];
   @ObfuscatedName("r")
   int field1552 = -1;
   @ObfuscatedName("d")
   int[] field1553;
   @ObfuscatedName("s")
   int[] field1554;
   @ObfuscatedName("z")
   class102 field1555 = null;
   @ObfuscatedName("f")
   int[] field1556;
   @ObfuscatedName("y")
   boolean field1557 = false;

   class88(byte[] var1, class102 var2) {
      this.field1555 = var2;
      class119 var3 = new class119(var1);
      class119 var4 = new class119(var1);
      var3.field2000 = 2;
      int var5 = var3.method2494();
      int var6 = -1;
      int var7 = 0;
      var4.field2000 = var3.field2000 + var5;

      int var8;
      for(var8 = 0; var8 < var5; ++var8) {
         int var9 = var3.method2494();
         if(var9 > 0) {
            if(this.field1555.field1771[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.field1555.field1771[var10] == 0) {
                     field1551[var7] = var10;
                     field1548[var7] = 0;
                     field1549[var7] = 0;
                     field1550[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1551[var7] = var8;
            short var11 = 0;
            if(this.field1555.field1771[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1548[var7] = var4.method2565();
            } else {
               field1548[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1549[var7] = var4.method2565();
            } else {
               field1549[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1550[var7] = var4.method2565();
            } else {
               field1550[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.field1555.field1771[var8] == 5) {
               this.field1557 = true;
            }
         }
      }

      if(var4.field2000 != var1.length) {
         throw new RuntimeException();
      } else {
         this.field1552 = var7;
         this.field1556 = new int[var7];
         this.field1554 = new int[var7];
         this.field1553 = new int[var7];
         this.field1547 = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1556[var8] = field1551[var8];
            this.field1554[var8] = field1548[var8];
            this.field1553[var8] = field1549[var8];
            this.field1547[var8] = field1550[var8];
         }

      }
   }
}
