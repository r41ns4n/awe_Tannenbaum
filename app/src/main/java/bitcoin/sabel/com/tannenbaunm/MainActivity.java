package bitcoin.sabel.com.tannenbaunm;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    // Data FIELDS
    private Button btn_draw;
    private TextView tv_tree;
    private EditText et_treeheight;
    private String stringHeight;
    private int intTreeHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_draw = findViewById(R.id.btn_draw);
        et_treeheight = findViewById(R.id.et_treeheight);
        tv_tree = findViewById(R.id.tv_tree);
        tv_tree.setMovementMethod(new ScrollingMovementMethod());

        // EVENT BUTTON DRAW
        btn_draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_treeheight.getText().toString().length() > 0) {
                    stringHeight = et_treeheight.getText().toString();
                    intTreeHeight = Integer.parseInt(stringHeight);
                    String treeReady = calculateTree(intTreeHeight);
                    tv_tree.setText(treeReady);
                } else {
                    tv_tree.setText("Sie müssen eine Zahl als Höhe eingeben");
                } // END IF-ELSE
            } // END OVERRIDE
        }); // END EVENT BUTTON DRAW

    } // END Override

    // METHODS
    private String calculateTree(int intTreeHeight) {
        // StringBuilder für die Ausgabe
        StringBuilder stringBuilder = new StringBuilder();
        // Tannenbaumspitze
        stringBuilder.append("@");

        // Äußere Schleife für den Zeilenumbruch
        for (int i = 0; i <= intTreeHeight; i++){
            // Innere Schleife für das Anfügen der Zeichen
            for (int a = 0; a < i; a++) {
                stringBuilder.append("*");
            } // END FOR (Innere Schleife)
            stringBuilder.append(String.format("%n"));
        } // END FOR (Äußere Schleife)

        // Schleife für den Stamm
        intTreeHeight = intTreeHeight / 4;
        for (int s = 0; s <= intTreeHeight; s++) {
            stringBuilder.append("#" + String.format("%n"));
        } // END FOR

        return stringBuilder.toString();
    } // END private String calculateTree(int height)

} // END CLASS MainActivity
