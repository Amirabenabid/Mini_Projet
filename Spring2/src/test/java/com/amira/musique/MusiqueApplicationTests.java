package com.amira.musique;
import java.util.Date;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.musique.entities.Musique;
import com.example.musique.entities.Style;
import com.example.musique.repos.MusiqueRepository;
import com.example.musique.service.MusiqueService;

@SpringBootTest
class MusiqueApplicationTests {
@Autowired
private MusiqueRepository musiqueRepository;

@Autowired
private MusiqueService musiqueService;

@Test
public void testFindMusique()
{
//Musique p = musiqueRepository.findById(1L).get(); 
//System.out.println(p);
}
@Test
public void testUpdateMusique()
{
//Musique p= musiqueRepository.findById(1L).get();
//p.setPrixMusique(1000.0);
//musiqueRepository.save(p);
}
@Test
public void testDeleteMusique()
{
musiqueRepository.deleteById(1L);;
}
 
@Test
public void testListerTousMusiques()
{
List<Musique> prods = musiqueRepository.findAll();
for (Musique p : prods)
{
System.out.println(p);
}
}
@Test
public void testFindByNomMusiqueContains()
{
Page<Musique> prods = musiqueService.getAllMusiquesParPage(0,2);
System.out.println(prods.getSize());
System.out.println(prods.getTotalElements());
System.out.println(prods.getTotalPages());
prods.getContent().forEach(p -> {System.out.println(p.toString());
 });

}
@Test
public void testFindByNomMusique()
{
List<Musique> prods = musiqueRepository.findByNomMusique("Stromae – Multitude");
for (Musique p : prods)
{
System.out.println(p);
}
}
@Test
public void findByNomMusiqueContains()
{
List<Musique> prods=musiqueRepository.findByNomMusiqueContains("P");
for (Musique p : prods)
{
System.out.println(p);
} }
/*@Test
public void testfindByNomPrix()
{
List<Musique> prods = MusiqueRepository.findByNomPrix("Stromae – Multitude"+, 10.0);
for (Musique p : prods)
{
System.out.println(p);
}
}*/

@Test
public void testfindByStyle()
{
Style cat = new Style();
cat.setIdStyle(1L);
List<Musique> prods = musiqueRepository.findByStyle(cat);
for (Musique p : prods)
{
System.out.println(p);
}
}
@Test
public void findByStyleIdStyle()
{
List<Musique> prods = musiqueRepository.findByStyleIdStyle(1L);
for (Musique p : prods)
{
System.out.println(p);
}
 }
@Test
public void testfindByOrderByNomMusiqueAsc()
{
List<Musique> prods = musiqueRepository.findByOrderByNomMusiqueAsc();
for (Musique p : prods)
{
System.out.println(p);
}
}
@Test
public void testTrierMusiquesNomsPrix()
{
List<Musique> prods = musiqueRepository.trierMusiquesNomsPrix();
for (Musique p : prods)
{
System.out.println(p);
}
}
}
