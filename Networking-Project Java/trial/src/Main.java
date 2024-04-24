
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.UIManager;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;

import com.pagosoft.plaf.PgsLookAndFeel;

@SuppressWarnings({"unused" })



public class Main
{


    public static void main(String[] args) throws InvalidKeyException, DataLengthException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, IllegalStateException, InvalidCipherTextException
    {

        try
        {
            UIManager.setLookAndFeel("com.pagosoft.plaf.PgsLookAndFeel");
        }

        catch (Exception e)
        {
            ;
        }
        GUI MainGUI = new GUI();
        MainGUI.ConstructGUI();

//		String CT = TextEncrypt.CBCDecrypt("8mjf2sqScPChi5lJQut6U5phB6IW8ze90WdqDm+ulLU1NWI2ODZlYzVmMjYxYTA5", "secret", 256, 0, "Q");
//
//		System.out.println(CT);

    }

}
