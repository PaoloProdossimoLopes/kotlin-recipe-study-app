package com.example.recipes

import android.net.Uri
import com.example.foods.features.recipes.client.RecipeClient
import com.example.foods.features.recipes.client.RecipeResponse
import com.example.foods.features.recipes.model.ResultListener
import java.util.Date
import java.util.Timer
import java.util.UUID
import kotlin.concurrent.schedule

class AddDelayDecorator<T: RecipeClient>(private val decratee: T): RecipeClient {
    override fun fetch(result: ResultListener<List<RecipeResponse>>) {
        Timer("completion", false).schedule(5000) {
            decratee.fetch(result)
        }
    }
}

class InmemmoryRecipeClient: RecipeClient {
    override fun fetch(result: ResultListener<List<RecipeResponse>>) {
        result.onSuccess(generateMockRecipes())
    }

    fun generateMockRecipes(count: Int = 30): List<RecipeResponse> {
        val titles = listOf(
            "Bolo de Chocolate",
            "Pizza Margherita",
            "Sopa de Legumes",
            "Salada Caesar",
            "Pão de Queijo",
            "Macarrão à Bolonhesa",
            "Frango Assado com Batatas",
            "Torta de Maçã",
            "Brigadeiro",
            "Lasanha de Frango",
            "Coxinha de Frango",
            "Risoto de Cogumelos",
            "Moqueca de Peixe",
            "Pudim de Leite Condensado",
            "Churrasco de Carne",
            "Panquecas Americanas",
            "Arroz à Piamontese",
            "Quiche Lorraine",
            "Espaguete ao Alho e Óleo",
            "Feijoada",
            "Sushi",
            "Tiramisu",
            "Cupcake de Baunilha",
            "Empadão de Frango",
            "Smoothie de Frutas",
            "Mousse de Chocolate",
            "Pastel de Queijo",
            "Pão de Alho",
            "Salmão Grelhado",
            "Brownie de Chocolate",
            "Creme de Abóbora",
            "Hambúrguer Caseiro",
            "Torta de Limão",
            "Sopa de Cebola",
            "Arroz Doce",
            "Frango Xadrez",
            "Pão Integral",
            "Salada Caprese",
            "Pão de Banana",
        )

        val thumbUrl = listOf(
            "https://www.oetker.com.br/Recipe/Recipes/oetker.com.br/br-pt/baking/image-thumb__40008__RecipeDetailsLightBox/bolo-de-aniversario-de-chocolate.jpg",
            "https://anamariabraga.globo.com/wp-content/uploads/2020/08/pizza-margherita.jpg",
            "https://assets.unileversolutions.com/recipes-v2/36850.jpg",
            "https://p2.trrsf.com/image/fget/cf/1200/900/middle/images.terra.com/2023/02/28/whatsapp-image-2023-02-28-at-01-53-47-(1)-1iyhprrq5e9tc.jpeg",
            "https://www.receitasnestle.com.br/sites/default/files/srh_recipes/6131b4013456c413556c9e811aff75d2.jpg",
            "https://static.itdg.com.br/images/1200-630/7c13d4a45d6696c610cf9664e477e836/macarrao-a-bolonhesa.jpg",
            "https://assets.unileversolutions.com/recipes-v2/36770.jpg",
            "https://www.casalcozinha.com.br/wp-content/uploads/2020/11/receita-simples-e-caseira-de-torta-de-maca-1300x932.png",
            "https://static.itdg.com.br/images/1200-675/379203965029eeed8d861ed802dfc051/201447-original.jpg",
            "https://p2.trrsf.com/image/fget/cf/1200/900/middle/images.terra.com/2021/08/22/1759609683-lasanha-de-frango-rose-768x512.jpg",
            "https://www.comidaereceitas.com.br/wp-content/uploads/2022/11/coxinha-780x520.jpg",
            "https://naminhapanela.com/wp-content/uploads/2015/09/IMG_8646.jpg?ezimgfmt=rs:412x274/rscb1/ngcb1/notWebP",
            "https://cdn.panelinha.com.br/receita/1667331718167-Formato%20Blog_0001s_0003_Curves%201.jpg",
            "https://static.itdg.com.br/images/1200-630/59e079217cc8af8291a8cb910d1d449f/318825-original.jpg",
            "https://supermercadosrondon.com.br/guiadecarnes/images/postagens/as_7_melhores_carnes_para_churrasco_21-05-2019.jpg",
            "https://www.sabornamesa.com.br/media/k2/items/cache/37006d1f78a382af9c665654f8162781_XL.jpg",
            "https://cooknenjoy.com/wp-content/uploads/2020/11/arroz-piamontese-01.jpg",
            "https://natashaskitchen.com/wp-content/uploads/2019/11/Classic-Quiche-Lorraine-Recipe-Beautiful-flaky-pastry-crust-is-paired-with-a-delicious-savory-egg-custard.-Perfect-for-breakfast-or-brunch.-1-4.jpg",
            "https://truffle-assets.tastemadecontent.net/814096b9-ESPAGUETE_ALHO_E_OLEO_THUMB_1080x1080---auto-cropped.jpg",
            "https://cdn.panelinha.com.br/receita/1588270905274-39_Panelinha_12_02_200635.jpg",
            "https://blogsakura.com.br/wp-content/uploads/2021/11/Blog1_01NOV21.jpg",
            "https://www.cozinhatecnica.com/wp-content/uploads/2019/10/receita-de-tiramisu-pexels-min-che-6880219.jpg",
            "https://renata.com.br/images/receitas/221/renata-imagem-receitas-cupcake-de-baunilha-share.jpg",
            "https://receitatodahora.com.br/wp-content/uploads/2020/02/empadao-de-frango-scaled.jpg",
            "https://www.mundoboaforma.com.br/wp-content/uploads/2022/02/Smoothie-frutas-vermelhas.jpg",
            "https://www.receitasnestle.com.br/sites/default/files/srh_recipes/369562012750bd46ceaeef5d59a23229.jpg",
            "https://www.comidaereceitas.com.br/img/sizeswp/1200x675/2008/08/pastel_queijo.jpg",
            "https://naminhapanela.com/wp-content/uploads/2023/02/Pao-de-alho-no-forno-3.jpg",
            "https://www.dicasdemulher.com.br/wp-content/uploads/2020/01/salmao-grelhado-0.png",
            "https://www.confeiteiradesucesso.com/wp-content/uploads/2020/08/receitabrownieamericano.jpg",
            "https://img.cybercook.com.br/imagens/receitas/495/creme-de-abobora.jpg",
            "https://i.ytimg.com/vi/87lF_F1VO1s/maxresdefault.jpg",
            "https://www.oetker.com.br/Recipe/Recipes/oetker.com.br/br-pt/dessert/image-thumb__98508__RecipeDetail/torta-de-limao.jpg",
            "https://assets.delirec.com/images%2FwnktB4k9tAcdlEBuSbYXr4x3sIZ2%2Frecipe%2F216e3776-ca93-424e-960b-72a22e6fc902-Sopa-de-Cebola-gallery-0",
            "https://marolacomcarambola.com.br/wp-content/uploads/2019/06/receita-de-arroz-doce-com-leite-condensado-12.jpg",
            "https://img.cybercook.com.br/receitas/786/frango-xadrez-6.jpeg",
            "https://saintclairebakery.com.br/wp-content/uploads/2023/06/pao-pao.jpg",
            "https://www.dicasdemulher.com.br/wp-content/uploads/2019/03/salada-caprese.jpg",
            "https://melepimenta.com/wp-content/uploads/2020/06/Pao-de-banana-fofissimo-Baixa-12.jpg",
        )

        val descriptions = listOf(
            "Deliciosa receita de bolo de chocolate.",
            "Uma pizza clássica com molho de tomate, queijo e manjericão.",
            "Uma sopa reconfortante com uma variedade de legumes.",
            "Uma salada refrescante com alface, croutons e queijo parmesão.",
            "Tradicional quitute brasileiro feito com polvilho doce e queijo minas.",
            "Um prato de macarrão com molho à bolonhesa.",
            "Frango assado ao forno acompanhado de batatas e temperos.",
            "Uma deliciosa torta de maçã com massa folhada e um toque de canela.",
            "Um doce clássico brasileiro feito com leite condensado, chocolate em pó e granulado.",
            "Camadas de massa de lasanha intercaladas com frango e molhos.",
            "Coxinhas de frango crocantes e saborosas, perfeitas para petiscar.",
            "Um delicioso risoto feito com cogumelos frescos e arroz arbóreo.",
            "Uma tradicional receita de moqueca brasileira com peixe, leite de coco e dendê.",
            "Um doce cremoso à base de leite condensado, perfeito para sobremesa.",
            "Uma deliciosa receita de churrasco de carne suculenta.",
            "Panquecas fofinhas servidas com xarope de bordo ou mel.",
            "Um arroz cremoso preparado com champignon e queijo parmesão.",
            "Uma torta salgada clássica feita com bacon e queijo gruyère.",
            "Uma massa simples e saborosa feita com alho e azeite.",
            "Um prato tradicional brasileiro com feijão preto e uma variedade de carnes.",
            "Uma iguaria japonesa com arroz temperado e fatias de peixe cru.",
            "Uma sobremesa italiana clássica feita com café, biscoitos champagne e queijo mascarpone.",
            "Cupcakes macios e deliciosos com sabor de baunilha.",
            "Uma torta salgada recheada com frango desfiado e coberta com massa.",
            "Uma bebida refrescante e saudável feita com frutas variadas.",
            "Um mousse de chocolate leve e aerado, perfeito para os amantes de chocolate.",
            "Deliciosos pastéis fritos recheados com queijo minas.",
            "Pão francês coberto com uma mistura de alho, manteiga e salsinha.",
            "Um prato de salmão grelhado com um toque de limão e ervas.",
            "Um clássico da confeitaria, o brownie é um bolo de chocolate denso e saboroso.",
            "Uma sopa cremosa feita com abóbora e temperos.",
            "Um hambúrguer suculento caseiro, preparado do seu jeito.",
            "Uma torta doce com sabor cítrico, perfeita para os amantes de limão.",
            "Uma sopa gratinada com cebolas caramelizadas e queijo gruyère.",
            "Um doce tradicional feito com arroz, leite, açúcar e canela.",
            "Um prato chinês delicioso feito com frango, pimentões e amendoim.",
            "Um pão saudável e nutritivo feito com farinha de trigo integral.",
            "Uma salada fresca e saborosa com tomate, queijo mussarela e manjericão.",
            "Um pão caseiro feito com bananas maduras e ingredientes simples.",
            "Um risoto rico e saboroso com frutos do mar, como camarão e lula.",
            "Bolinhos fritos e doces, perfeitos para acompanhar um café.",
            "Uma deliciosa receita de escondidinho com carne moída e purê de mandioca.",
            "Uma torta francesa de maçã caramelizada com massa folhada.",
            "Um sorvete cremoso de chocolate para se refrescar nos dias quentes.",
            "Uma comida mexicana deliciosa com tortillas",
            "Uma sobremesa italiana clássica feita com café, biscoitos champagne e queijo mascarpone.",
            "Cupcakes macios e deliciosos com sabor de baunilha.",
            "Uma torta salgada recheada com frango desfiado e coberta com massa.",
            "Uma bebida refrescante e saudável feita com frutas variadas.",
            "Um mousse de chocolate leve e aerado, perfeito para os amantes de chocolate.",
            "Deliciosos pastéis fritos recheados com queijo minas."
        )

        val ingredientsList = listOf(
            listOf("Farinha", "Açúcar", "Chocolate em pó", "Ovos", "Leite"), // Bolo de Chocolate
            listOf("Massa de pizza", "Molho de tomate", "Queijo mussarela", "Manjericão"), // Pizza Margherita
            listOf("Batata", "Cenoura", "Abóbora", "Cebola", "Salsão"), // Sopa de Legumes
            listOf("Alface", "Croutons", "Queijo parmesão", "Molho Caesar"), // Salada Caesar
            listOf("Polvilho doce", "Queijo minas", "Ovos", "Leite", "Sal"), // Pão de Queijo
            listOf("Macarrão", "Carne moída", "Molho de tomate", "Cebola", "Alho"), // Macarrão à Bolonhesa
            listOf("Frango", "Batatas", "Limão", "Alho", "Ervas frescas"), // Frango Assado com Batatas
            listOf("Massa folhada", "Maçãs", "Açúcar", "Canela", "Limão"), // Torta de Maçã
            listOf("Leite condensado", "Chocolate em pó", "Manteiga", "Granulado"), // Brigadeiro
            listOf("Massa de lasanha", "Peito de frango", "Molho branco", "Queijo mussarela", "Molho de tomate"), // Lasanha de Frango
            listOf("Frango cozido e desfiado", "Caldo de galinha", "Farinha de trigo", "Ovos", "Farinha de rosca"), // Coxinha de Frango
            listOf("Arroz arbóreo", "Cogumelos", "Cebola", "Vinho branco", "Caldo de legumes"), // Risoto de Cogumelos
            listOf("Peixe", "Leite de coco", "Dendê", "Pimentões", "Coentro"), // Moqueca de Peixe
            listOf("Leite condensado", "Leite", "Ovos", "Açúcar", "Água"), // Pudim de Leite Condensado
            listOf("Carne (picanha, maminha, alcatra)", "Sal grosso", "Temperos a gosto"), // Churrasco de Carne
            listOf("Farinha de trigo", "Leite", "Ovos", "Açúcar", "Fermento em pó"), // Panquecas Americanas
            listOf("Arroz", "Champignon", "Vinho branco", "Queijo parmesão", "Creme de leite"), // Arroz à Piamontese
            listOf("Massa quebrada", "Bacon", "Queijo gruyère", "Creme de leite", "Ovos"), // Quiche Lorraine
            listOf("Espaguete", "Alho", "Azeite de oliva", "Pimenta vermelha", "Salsinha"), // Espaguete ao Alho e Óleo
            listOf("Feijão preto", "Carne de porco (costela, lombo, paio)", "Linguiça calabresa", "Bacon", "Farinha de mandioca"), // Feijoada
            listOf("Arroz para sushi", "Peixe cru (salmão, atum)", "Alga nori", "Vinagre de arroz", "Wasabi"), // Sushi
            listOf("Biscoitos champagne", "Café forte", "Queijo mascarpone", "Ovos", "Cacau em pó"), // Tiramisu
            listOf("Farinha de trigo", "Açúcar", "Manteiga", "Ovos", "Leite"), // Cupcake de Baunilha
            listOf("Farinha de trigo", "Manteiga", "Frango desfiado", "Caldo de galinha", "Ovos"), // Empadão de Frango
            listOf("Frutas variadas (banana, morango, manga)", "Iogurte natural", "Suco de laranja", "Mel", "Gelo"), // Smoothie de Frutas
            listOf("Chocolate meio amargo", "Ovos", "Açúcar", "Manteiga", "Creme de leite"), // Mousse de Chocolate
            listOf("Massa de pastel", "Queijo minas", "Orégano", "Óleo (para fritar)"), // Pastel de Queijo
            listOf("Pão francês", "Manteiga", "Alho", "Salsinha", "Queijo parmesão"), // Pão de Alho
            listOf("Filé de salmão", "Limão", "Azeite de oliva", "Sal", "Pimenta-do-reino"), // Salmão Grelhado
            listOf("Chocolate meio amargo", "Manteiga", "Açúcar", "Ovos", "Farinha de trigo"), // Brownie de Chocolate
            listOf("Abóbora", "Cebola", "Alho", "Caldo de legumes", "Creme de leite"), // Creme de Abóbora
            listOf("Carne moída", "Cebola", "Alho", "Ovos", "Pão de hambúrguer"), // Hambúrguer Caseiro
            listOf("Massa de biscoito", "Leite condensado", "Limão", "Creme de leite", "Açúcar"), // Torta de Limão
            listOf("Cebolas", "Caldo de carne", "Vinho branco", "Queijo gruyère", "Croutons"), // Sopa de Cebola
            listOf("Arroz", "Leite", "Açúcar", "Canela em pau", "Casca de limão"), // Arroz Doce
            listOf("Peito de frango", "Pimentões", "Cebola", "Molho de soja", "Amendoim"), // Frango Xadrez
            listOf("Farinha de trigo integral", "Fermento biológico", "Mel", "Óleo", "Sal"), // Pão Integral
            listOf("Tomate", "Queijo mussarela", "Manjericão", "Azeite de oliva", "Vinagre balsâmico"), // Salada Caprese
            listOf("Bananas maduras", "Farinha de trigo", "Açúcar", "Manteiga", "Fermento em pó"), // Pão de Banana
        )

        val authors = listOf(
            "João Silva",
            "Maria Santos",
            "Carlos Oliveira",
            "Ana Rodrigues"
        )

        val currentDateTime = Date()

        val recipeList = ArrayList<RecipeResponse>(count)

        repeat(count) { index ->
            val id = UUID.randomUUID()
            val title = titles[index]
            val description = descriptions[index]
            val ingredients = ingredientsList[index]
            val thumbnailUrl = thumbUrl[index]
            val author = authors.random()

            val recipe = RecipeResponse(
                id = id,
                title = title,
                description = description,
                ingredients = ingredients,
                createdAt = currentDateTime,
                author = author,
                thumbnailUrl = Uri.parse(thumbnailUrl)
            )
            recipeList.add(recipe)
        }

        return recipeList
    }
}