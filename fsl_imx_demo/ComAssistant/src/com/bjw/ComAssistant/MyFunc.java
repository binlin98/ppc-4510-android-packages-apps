package com.bjw.ComAssistant;

/**
 * @author benjaminwan
 *数据转换工具
 */
public class MyFunc {
	//-------------------------------------------------------
	// judge odd or even number, bit operation, last is 1, odd number, 0 is even number
    static public int isOdd(int num)
	{
		return num & 0x1;
	}
    //-------------------------------------------------------
    static public int HexToInt(String inHex)//hex string to int
    {
    	return Integer.parseInt(inHex, 16);
    }
    //-------------------------------------------------------
    static public byte HexToByte(String inHex)//ex string to byte
    {
    	return (byte)Integer.parseInt(inHex,16);
    }
    //-------------------------------------------------------
    static public String Byte2Hex(Byte inByte)//1 bytes to 2 Hex characters
    {
    	return String.format("%02x", inByte).toUpperCase();
    }
    //-------------------------------------------------------
	static public String ByteArrToHex(byte[] inBytArr)//byte array to hex string
	{
		StringBuilder strBuilder=new StringBuilder();
		int j=inBytArr.length;
		for (int i = 0; i < j; i++)
		{
			strBuilder.append(Byte2Hex(inBytArr[i]));
			strBuilder.append(" ");
		}
		return strBuilder.toString(); 
	}
  //-------------------------------------------------------
    static public String ByteArrToHex(byte[] inBytArr,int offset,int byteCount)//byte array to hex string, optional length
	{
    	StringBuilder strBuilder=new StringBuilder();
		int j=byteCount;
		for (int i = offset; i < j; i++)
		{
			strBuilder.append(Byte2Hex(inBytArr[i]));
		}
		return strBuilder.toString();
	}
	//-------------------------------------------------------
	//convert hex string to byte array
    static public byte[] HexToByteArr(String inHex)//hex string to byte array
	{
		int hexlen = inHex.length();
		byte[] result;
		if (isOdd(hexlen)==1)
		{//Odd
			hexlen++;
			result = new byte[(hexlen/2)];
			inHex="0"+inHex;
		}else {//Even
			result = new byte[(hexlen/2)];
		}
	    int j=0;
		for (int i = 0; i < hexlen; i+=2)
		{
			result[j]=HexToByte(inHex.substring(i,i+2));
			j++;
		}
	    return result; 
	}
}