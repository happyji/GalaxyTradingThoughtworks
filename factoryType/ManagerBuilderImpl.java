package factoryType;
import factory.ManagerBuilder;
import factoryType.mapper.MetalCreditMapper;
import factoryType.mapper.SymbolRomanMapper;
import factoryType.query.QuantityQuery;
import factoryType.query.CreditQuery;
import factoryType.repository.FactoryTypeRepository;


public class ManagerBuilderImpl extends ManagerBuilder {

   @Override
    public void build() {
        FactoryTypeRepository.add(SymbolRomanMapper.getInstance());
        FactoryTypeRepository.add(MetalCreditMapper.getInstance());
        FactoryTypeRepository.add(CreditQuery.getInstance());
        FactoryTypeRepository.add(QuantityQuery.getInstance());
        FactoryTypeRepository.add(InvalidInput.getInstance());
    }
}
