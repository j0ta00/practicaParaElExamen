package com.example.juanjomz.practicaparaelexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    public List<Equipo> equiposEsport;
    public List<Equipo> equiposEsportListView;
    public Spinner spnEquipos;
    public Button btn;
    public ListView lsvEquipos;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        equiposEsport=new LinkedList<Equipo>();
        equiposEsportListView=new LinkedList<Equipo>();
        llenarLista();
        btn=findViewById(R.id.btnLsv);
        spnEquipos=findViewById(R.id.spnItems);
        lsvEquipos=findViewById(R.id.lsvItems);
        spnEquipos.setAdapter(new SpinnerAdapter<Equipo>(this,equiposEsport));
        spnEquipos.setOnItemSelectedListener(this);
        btn.setOnClickListener(this);
    }

    public void llenarLista(){
        equiposEsport.add(new Equipo((R.drawable.v),"v de vendetta"));
        equiposEsport.add(new Equipo((R.drawable.movistarcompartidalavidaesmas),"movistar"));
        equiposEsport.add(new Equipo((R.drawable.vodafone),"vodafone"));
        equiposEsport.add(new Equipo((R.drawable.g2),"g2"));
        equiposEsport.add(new Equipo((R.drawable.a2),"a2"));
        equiposEsport.add(new Equipo((R.drawable.a),"a"));
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){
        equiposEsportListView.add(equiposEsport.get(i));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView){}

    @Override
    public void onClick(View view) {
        lsvEquipos.setAdapter(new ListAdapter<Equipo>(this,equiposEsportListView));
    }

    class ListAdapter<T> extends BaseAdapter{
        private List<Equipo> listaEquiposListView;
        private Context context;

        public ListAdapter(Context context,List<Equipo> listaEquiposAdapter){
            this.listaEquiposListView=listaEquiposAdapter;
            this.context=context;
        }

        @Override
        public int getCount() {
            return listaEquiposListView.size() ;
        }

        @Override
        public Object getItem(int i) {
            return listaEquiposListView.get(i);
        }

        @Override
        public long getItemId(int i){
            return listaEquiposListView.get(i).hashCode();
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            View row=convertView;
            ImageView img=null;
            TextView txt=null;
            LayoutInflater inflater=null;
            viewHolder holder=null;
            if(row==null){
                inflater=getLayoutInflater();
                row=inflater.inflate(R.layout.list_row,parent,false);
                img=row.findViewById(R.id.lsvImg);
                txt=row.findViewById(R.id.lsvTxt);
                holder=new viewHolder(img,txt);
                row.setTag(holder);
            }else{
                holder=(viewHolder) row.getTag();
            }
            holder.getImg().setImageResource(listaEquiposListView.get(i).getIdImagen());
            holder.getTxt().setText(listaEquiposListView.get(i).getNombreEquipo());
            return row;
        }
    }
    class SpinnerAdapter<T> extends BaseAdapter{
        private List<Equipo> listaEquiposAdapter;
        private Context context;

        public SpinnerAdapter(Context context,List<Equipo> listaEquiposAdapter){
            this.listaEquiposAdapter=listaEquiposAdapter;
            this.context=context;
        }

        @Override
        public int getCount() {
            return listaEquiposAdapter.size() ;
        }

        @Override
        public Object getItem(int i) {
            return listaEquiposAdapter.get(i);
        }

        @Override
        public long getItemId(int i){
            return listaEquiposAdapter.get(i).hashCode();
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            View row=convertView;
            ImageView img=null;
            TextView txt=null;
            LayoutInflater inflater=null;
            viewHolder holder=null;
            if(row==null){
                inflater=getLayoutInflater();
                row=inflater.inflate(R.layout.spinner_row,parent,false);
                img=row.findViewById(R.id.imgEquipo);
                txt=row.findViewById(R.id.nombreEquipo);
                holder=new viewHolder(img,txt);
                row.setTag(holder);
            }else{
                holder=(viewHolder) row.getTag();
            }
            holder.getImg().setImageResource(listaEquiposAdapter.get(i).getIdImagen());
            holder.getTxt().setText(listaEquiposAdapter.get(i).getNombreEquipo());
            return row;
        }
    }
    }

    class viewHolder{

        private ImageView img;
        private TextView txt;

        public viewHolder(ImageView img,TextView txt){
            this.img=img;
            this.txt=txt;
        }

        public ImageView getImg() {
            return img;
        }

        public TextView getTxt() {
            return txt;
        }

    }