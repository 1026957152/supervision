package org.ylgjj.loan.repository_flow;


import org.springframework.data.jpa.repository.JpaRepository;
import org.ylgjj.loan.domain_flow.TableMetadata;

public interface TableMetadataRepository extends JpaRepository<TableMetadata, org.ylgjj.loan.domain_flow.TableMetadata.TableMetadataKey>
{
  TableMetadata findByTableName(String tableName);
}